class Constructors4(hello: String, name: String) {
  println("In the main constructor")
  def this(hello: String) = {
    this(hello, "John")
    println("In the first additional constructor")
  }
  def this() = {
    this("Hello")
    println("In the second additional constructor")
  }
  def greet = hello + " " + name
}
