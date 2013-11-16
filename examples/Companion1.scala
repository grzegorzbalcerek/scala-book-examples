class Companion1(greeting: String) {
  private def greet1: String = greeting + " (private)"
  def greet2 = Companion1.greet3
}
object Companion1 {
  def apply(greeting: String) = new Companion1(greeting)
  private def greet3: String  = "Hello (private)"
  def greet4(instance: Companion1) = instance.greet1
}
