class Greet(hello: String, name: String) {
  def greet = println(hello + " " + name)
}
class GreetPeter(hello: String) extends Greet(hello, "Peter")
class HiPeter extends GreetPeter("Hi")
