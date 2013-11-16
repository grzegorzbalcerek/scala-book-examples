class Constructors2(sayHello: Boolean) {
  val greeting = if (sayHello) "Hello" else "Hi"
  println("I will say '" + greeting + "', like this:")
  speak
  def speak = println(greeting)
}
