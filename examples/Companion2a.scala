class Companion2(greeting: String) {
  private def greet1 = println(greeting + " (class private)")
  def greet2 = Companion2.greet3
}
