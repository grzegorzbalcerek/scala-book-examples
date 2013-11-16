class DeprecatedGreetings(greeting: String) {
  @deprecated("use greet instead","1.1") def hi = println("hi!")
  @deprecated("use greet instead","1.1")
  def hello = println("hello!")
  def greet = println(greeting + "!")
}
object DeprecatedGreetings {
  def main(args: Array[String]) {
    val g = new DeprecatedGreetings("Hello")
    g.hello
    g.greet
  }
}
