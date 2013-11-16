trait Hello5 {
  val name: String
  val greeting = "Hello "+name+"!"
  def hello = println(greeting)
}
class Hello5Mary extends Hello5 { val name = "Mary" }
