class Hello3 { def speak = println("Hello") }
class Hi3 extends Hello3 {
  def speak = println("Hi")
  def hi = speak
}
