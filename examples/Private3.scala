object Hello3 {
  private def dialog(h1: Hello3, h2: Hello3) {
    h1.speak
    h2.speak
  }
}
class Hello3(greeting: String) {
  private def speak = println(greeting)
  def talkTo(other: Hello3) = Hello3.dialog(this, other)
}
