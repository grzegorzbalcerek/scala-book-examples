object BaseGreeting9 {
  implicit object HelloGreeting9 extends Greeting9("Hello","!")
  object WelcomeGreeting9 extends Greeting9("Welcome","!!")
}
class BaseGreeting9
class Greeting9(val greetWord: String, val ending: String) extends BaseGreeting9
object ImplicitParams9 {
  def greeting(name: String)(implicit g: Greeting9):String =
    g.greetWord + " " + name + g.ending
}
