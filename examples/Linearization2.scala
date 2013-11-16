trait HelloGreet { def greet = "Hello!" }
trait WelcomeGreet { override def greet = "Welcome!" }
class HelloWelcomeGreet extends HelloGreet with WelcomeGreet
