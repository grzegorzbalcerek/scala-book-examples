import akka.actor._
object Guess2 {
  def main(args: Array[String]) {
    println("Guess2: begin")
    val system = ActorSystem("Guess2")
    val server = ActorDSL.actor(system,"GuessServer2")(new GuessServer2)
    val client = ActorDSL.actor(system)(new GuessClient2)
    import scala.concurrent.duration._
    implicit val timeout = akka.util.Timeout(5.seconds)
    import system.dispatcher
    import akka.pattern.ask
    val responseFuture = client ? 'start
    responseFuture.onSuccess { case response =>
      println("Guess2: received response: "+response)
      client ! 'stop
    }
    println("Guess2: end")
  }
}

class GuessClient2 extends Actor {
  println("GuessClient2: starting")
  private[this] var n: Int = 5
  val server = context.actorFor("../GuessServer2")
  def receive = {
    case 'start =>
      val guessSender = sender
      send(n)
      context.become {
        case 'correct =>
          println(s"GuessClient2: solution found: $n")
          context.unbecome()
          guessSender ! n
        case 'tooSmall =>
          println("GuessClient2: too small")
          n = n + 1
          send(n)
        case 'tooBig =>
          println("GuessClient2: too big")
          n = n - 1
          send(n)
      }
    case 'stop =>
      println("GuessClient2: stopping")
      context.system.shutdown()
  }
  def send(msg: Int) {
    println(s"GuessClient2: sending $msg")
    server ! msg
  }
}

class GuessServer2 extends Actor {
  val n = scala.util.Random.nextInt(10)
  println("GuessServer2: starting")
  def receive = {
    case x:Int if x > n => send(sender, 'tooBig)
    case x:Int if x < n => send(sender, 'tooSmall)
    case x:Int =>          send(sender, 'correct)
  }
  def send(sender: ActorRef, msg: Symbol) {
    println(s"GuessServer2: sending $msg")
    sender ! msg
  }
  override def preStart() = println("GuessServer2: preStart")
  override def postStop() = println("GuessServer2: preStop")
}
