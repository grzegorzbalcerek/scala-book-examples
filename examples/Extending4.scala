class Hello4 { def speak = println("Hello") }
class Hi4 extends Hello4 {
  override def speak = println("Hi")
  override def hi = speak
}
