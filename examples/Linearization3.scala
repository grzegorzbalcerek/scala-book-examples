trait Greet { def greet: String }
trait HelloGreet extends Greet { override def greet = "Hello!" }
trait WelcomeGreet extends Greet { override def greet = "Welcome!" }
class HelloWelcomeGreet extends HelloGreet with WelcomeGreet
class WelcomeHelloGreet extends WelcomeGreet with HelloGreet
