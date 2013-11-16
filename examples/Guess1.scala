import akka.actor._
object Guess1 {
  def main(args: Array[String]) {
    val system = ActorSystem("Guess1")
    val server = ActorDSL.actor(system)(new GuessServer1)
    val client = ActorDSL.actor(system)(new GuessClient1(server))
    client ! 'startGuessing
  }
}

class GuessClient1(server: ActorRef) extends Actor {
  println("GuessClient1: starting")
  private[this] var n: Int = 5
  def receive = {
    case 'startGuessing =>
      send(n)
    case 'correct =>
      println(s"GuessClient1: solution found: $n")
      context.system.shutdown()
    case 'tooSmall =>
      println("GuessClient1: too small")
      n = n + 1
      send(n)
    case 'tooBig =>
      println("GuessClient1: too big")
      n = n - 1
      send(n)
  }
  def send(msg: Int) {
    println(s"GuessClient1: sending $msg")
    server ! msg
  }
}

class GuessServer1 extends Actor {
  val n = scala.util.Random.nextInt(10)
  println("GuessServer1: starting")
  def receive = {
    case x:Int if x > n =>
      send(sender, 'tooBig)
    case x:Int if x < n =>
      send(sender, 'tooSmall)
    case x:Int =>
      send(sender, 'correct)
      context.stop(self)
  }
  def send(sender: ActorRef, msg: Symbol) {
    println(s"GuessServer1: sending $msg")
    sender ! msg
  }
}
