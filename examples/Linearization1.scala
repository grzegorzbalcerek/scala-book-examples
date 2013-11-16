trait HelloGreet { def greet = "Hello!" }
trait WelcomeGreet { def greet = "Welcome!" }
class HelloWelcomeGreet extends HelloGreet with WelcomeGreet
