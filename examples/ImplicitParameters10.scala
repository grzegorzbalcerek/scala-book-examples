object Greeting10 {
  implicit object HelloMrGreeting10 extends Greeting10[Man]("Hello Mr.","!")
  implicit object HelloMrsGreeting10 extends Greeting10[Woman]("Hello Mrs.","!")
}
class Greeting10[T <: Person](val greetWord: String, val ending: String)
object ImplicitParams10 {
  def greeting[T <: Person](name: T)(implicit g: Greeting10[T]):String =
    g.greetWord + " " + name + g.ending
}
