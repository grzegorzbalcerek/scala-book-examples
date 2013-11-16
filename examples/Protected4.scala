class Greeting(greeting: String) {
  protected[this] def speak = println(greeting)
}
class Hello(name: String) extends Greeting("Hello "+name) {
  def talkTo(other: Hello) {
    this.speak
    other.speak
  }
}
