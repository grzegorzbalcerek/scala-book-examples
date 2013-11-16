class Hello2(greeting: String) {
  private[this] def speak = println(greeting)
  def dialog(other: Hello2) {
    this.speak
    other.speak
  }
}
