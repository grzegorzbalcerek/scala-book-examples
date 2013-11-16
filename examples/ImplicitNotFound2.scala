import scala.annotation.implicitNotFound
@implicitNotFound("an implicit Greetings object not found!!!!")
class Greetings(val greeting: String, val ending: String)
object ImplicitNotFound2 {
  def greet(names: String*)(implicit greetings: Greetings) =
    println(greetings.greeting + " " + names.mkString(", ") + greetings.ending)
  def main(args: Array[String]) = greet("Peter")
}
