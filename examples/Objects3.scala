object Hello3 {
  def apply(greeting: String) = new Hello3(greeting)
}
class Hello3(greeting: String) {
  def speak = println(greeting)
}
