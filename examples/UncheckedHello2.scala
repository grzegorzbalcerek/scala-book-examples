abstract sealed class Person(name: String)
case class Man(name: String) extends Person(name)
case class Woman(name: String) extends Person(name)
object UncheckedHello extends App {
  private def sayHello(person: Person) = (person: @unchecked) match {
    case Man(name) => println("Hello Mr. "+name+"!")
  }
  sayHello(Man("Peter"))
}
