class Greetings(val greeting: String, val ending: String)
object ImplicitNotFound1 {
  def greet(names: String*)(implicit greetings: Greetings) =
    println(greetings.greeting + " " + names.mkString(", ") + greetings.ending)
  def main(args: Array[String]) = greet("Peter")
}

