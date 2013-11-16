trait SuperGreet {
  def greet = "Greetings"
}
trait SuperHelloGreet extends SuperGreet {
  override def greet = super.greet + " Hello!"
}
trait SuperWelcomeGreet extends SuperGreet {
  override def greet = super.greet + " Welcome!"
}
class SuperHelloWelcomeGreet
extends SuperHelloGreet with SuperWelcomeGreet
class SuperWelcomeHelloGreet
extends SuperWelcomeGreet with SuperHelloGreet
