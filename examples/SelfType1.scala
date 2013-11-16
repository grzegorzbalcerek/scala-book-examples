class Person(val name: String)
trait Greeting {
  def greet = "Hello"
}
trait PersonGreeting extends Greeting { person: Person =>
  override def greet = super.greet + " " + person.name
}
