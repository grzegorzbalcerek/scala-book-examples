class Greeting7(val greetWord: String, val ending: String)
object ImplicitParams7 {
  implicit object HelloGreeting7 extends Greeting7("Hello","!")
  object WelcomeGreeting7 extends Greeting7("Welcome","!!")
  def greeting(name: String)(implicit g: Greeting7):String =
    g.greetWord + " " + name + g.ending
}
