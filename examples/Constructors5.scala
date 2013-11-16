class Constructors5(hello: String, name: String) {
  def this = this("Hi", "John")
  def this(hello: String) = {
    println("In an additional constructor")
    this(hello, "John")
  }
  def greet = hello + " " + name
}
