object TestTracePlugin2 {
  def main(args: Array[String]) {
    greet("Peter")
    greet("Mary")
  }
  def greet(name: String) = println(hello + " " + name + "!")
  def hello = "Hello"
}
