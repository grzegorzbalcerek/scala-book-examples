class Hello1(greeting: String) {
  private[this] def talk = println(greeting)
  def speak = talk
}
