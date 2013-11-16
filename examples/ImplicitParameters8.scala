object Greeting8 {
  implicit object HelloGreeting8 extends Greeting8("Hello","!")
  object WelcomeGreeting8 extends Greeting8("Welcome","!!")
}
class Greeting8(val greetWord: String, val ending: String)
object ImplicitParams8 {
  def greeting(name: String)(implicit g: Greeting8):String =
    g.greetWord + " " + name + g.ending
}
