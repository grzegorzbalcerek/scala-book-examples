trait AbstractGreeting {
  def greeting: String
  def greet = println(greeting)
}
class HelloGreeting extends AbstractGreeting {
  override def greeting = "Hello"
}
