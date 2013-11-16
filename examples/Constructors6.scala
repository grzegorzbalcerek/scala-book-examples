class Constructors6(hello: String, name: String) {
  def this() = this("Hello")
  def this(hello: String) = this(hello, "John")
  def greet = hello + " " + name
}
