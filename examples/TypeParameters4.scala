class Greeting(greeting: String) {
  def apply(person: Person) = println(greeting+" "+person.name+"!")
}
