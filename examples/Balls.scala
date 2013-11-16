import java.awt.geom._
import scala.swing._
import scala.swing.event._
import akka.actor._, ActorDSL._
import scala.concurrent.duration._
import scala.collection._
object Balls extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Balls"
    resizable = false
    val drawingPanel = new DrawingPanel(350)
    val system = ActorSystem("Balls")
    val controller = actor(system)(new ControllerActor(drawingPanel))
    contents = new FlowPanel(new AddBallButton(controller), drawingPanel)
    controller ! ClockEvent
  }
}

case class AddBall(ball: Ball)
case class Ball(color: Color, radius: Double, vx: Double, vy: Double)
case object ClockEvent
case class PositionUpdate(index: Int, position: Point)
case object UpdateRequest

class AddBallButton(controller: ActorRef) extends Button("add ball") {
  listenTo(this)
  import java.awt.Color._
  import scala.util.Random
  val colors = Array(BLACK,BLUE,CYAN,GREEN,MAGENTA,ORANGE,PINK,RED)
  reactions += {
    case ButtonClicked(_) => 
        val signx = if (Random.nextBoolean) 1 else -1
        val signy = if (Random.nextBoolean) 1 else -1
        controller ! AddBall(new Ball(
                       colors(Random.nextInt(colors.length)),
                       (10+Random.nextInt(10)).toDouble,
                       (signx*(10+Random.nextInt(40))).toDouble,
                       (signy*(10+Random.nextInt(40))).toDouble))
  }
}

class ControllerActor(drawingPanel: DrawingPanel) extends Actor {
  import scala.util.Random
  private[this] var ballsCounter = 0
  private[this] val positions = mutable.Map[Int, Point]()
  private[this] val balls = mutable.Map[Int, Ball]()
  private[this] val actors = mutable.Map[Int, ActorRef]()
  def receive = {
        case AddBall(ball) =>
          balls(ballsCounter) = ball
          val position = new Point(Random.nextInt(drawingPanel.dim),
                                   Random.nextInt(drawingPanel.dim))
          positions(ballsCounter) = position
          val index = ballsCounter
          actors(ballsCounter) = context.actorOf(Props(new BallActor(ball, position, index,
                                                                     drawingPanel.dim)))
          ballsCounter += 1
          updateDrawingPanelBalls
        case ClockEvent =>
          updateDrawingPanelPositions
          for (j <- 0 to ballsCounter-1) actors(j) ! UpdateRequest
          val system = context.system
          import system.dispatcher
          context.system.scheduler.scheduleOnce(25.milliseconds, self, ClockEvent)
        case PositionUpdate(index, pos) => positions(index) = pos
  }
  def updateDrawingPanelBalls {
    val balls2 = immutable.Map[Int, Ball]() ++ balls
    Swing.onEDT { drawingPanel.updateBalls(balls2) }
  }
  def updateDrawingPanelPositions {
    val pos2 = immutable.Map[Int, Point]() ++ positions
    Swing.onEDT { drawingPanel.updatePositions(pos2) }
  }
}

class BallActor(ball: Ball, position: Point, index: Int, dim: Double) extends Actor {
  private[this] var xPos = position.x.toDouble
  private[this] var yPos = position.y.toDouble
  private[this] var signx = math.signum(ball.vx)
  private[this] var signy = math.signum(ball.vy)
  private[this] var timestamp = System.currentTimeMillis
  def updatePosition {
    val newTimestamp = System.currentTimeMillis
    val intervalTime = newTimestamp - timestamp
    timestamp = newTimestamp
    val dx = (ball.vx * intervalTime / 1000.0).abs
    val dy = (ball.vy * intervalTime / 1000.0).abs
    xPos += dx * signx
    yPos += dy * signy
    if (xPos < ball.radius) { xPos = 2*ball.radius - xPos; signx = 1 }
    if (xPos > (dim-ball.radius)) {
      xPos = 2*(dim-ball.radius) - xPos; signx = -1 }
    if (yPos < ball.radius) { yPos = 2*ball.radius-yPos; signy = 1 }
    if (yPos > (dim-ball.radius)) {
      yPos = 2*(dim-ball.radius) - yPos; signy = -1 }
  }
  def receive = {
    case UpdateRequest =>
      updatePosition
      sender ! PositionUpdate(index, new Point(xPos.toInt, yPos.toInt))
  }
}

class DrawingPanel(val dim: Int) extends Panel {
  preferredSize = new Dimension(dim, dim)
  private[this] var balls = immutable.Map[Int, Ball]()
  private[this] var positions = immutable.Map[Int, Point]()
  def updateBalls(balls: immutable.Map[Int, Ball]) = this.balls = balls
  def updatePositions(pos: immutable.Map[Int, Point]) {
    this.positions = pos
    repaint()
  }
  override def paintComponent(g: Graphics2D)  {
    super.paintComponent(g)
    drawBorder
    drawBalls
    def drawBorder {
      g.setColor(java.awt.Color.BLACK)
      g.draw(new Rectangle(0,0,size.width-1,size.height-1))
    }
    def drawBalls {
      for((index, position) <- positions) {
        val ball = balls(index)
        g.setColor(ball.color)
        g.fill(new Ellipse2D.Double(position.x-ball.radius,
                                    position.y-ball.radius,
                                    2.0*ball.radius, 2.0*ball.radius))
      }
    }
  }
}

