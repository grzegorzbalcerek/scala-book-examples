class Greeting2[T <: Person](greeting: String) {
  def apply(person: T) = println(greeting+" "+person.name+"!")
}
