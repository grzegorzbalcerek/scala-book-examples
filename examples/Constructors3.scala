class Constructors3(sayHello: Boolean) {
  println("I will say '" + greeting + "', like this:")
  speak
  def speak = println(greeting)
  val greeting = if (sayHello) "Hello" else "Hi"
  println("I will say '" + greeting + "' now.")
  speak
}
