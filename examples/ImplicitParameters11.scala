abstract class Person2(name: String){ override def toString = name }
class Man2(name: String) extends Person2(name)
object Man2 {
  implicit object HelloMrGreeting11 extends Greeting11[Man2]("Hello Mr.","!")
}
class Woman2(name: String) extends Person2(name)
object Woman2 {
  implicit object HelloMrsGreeting11
           extends Greeting11[Woman2]("Hello Mrs.","!")
}
class Greeting11[T <: Person2](val greetWord: String, val ending: String)
object ImplicitParams11 {
  def greeting[T <: Person2](name: T)(implicit g: Greeting11[T]):String =
    g.greetWord + " " + name + g.ending
}
