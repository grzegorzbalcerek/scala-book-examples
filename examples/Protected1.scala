class Greeting(greeting: String) {
  private def speak = println(greeting)
  private[this] def speak2 = println(greeting + " " + greeting)
}
object Hello extends Greeting("Hello") {
  def talk = speak
  def talk2 = speak2
}
