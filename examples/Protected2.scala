class Greeting(greeting: String) {
  protected def speak = println(greeting)
  protected[this] def speak2 = println(greeting + " " + greeting)
}
object Hello extends Greeting("Hello") {
  def talk = speak
  def talk2 = speak2
}
