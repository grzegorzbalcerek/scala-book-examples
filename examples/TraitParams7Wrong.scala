trait Hello7 {
  val name: String
  val greeting = "Hello "+name+"!"
  def hello = println(greeting)
}
class Hello7Factory(paramName: String) {
  class Hello7Name extends Hello7 { val name = this.paramName }
  def create = new Hello7Name
}
