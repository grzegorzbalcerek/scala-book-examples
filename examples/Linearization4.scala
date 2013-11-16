trait Welcome2Greet extends HelloGreet {
  override def greet = "Welcome!"
}
class HelloWelcome2Greet extends HelloGreet with Welcome2Greet
class Welcome2HelloGreet extends Welcome2Greet with HelloGreet
