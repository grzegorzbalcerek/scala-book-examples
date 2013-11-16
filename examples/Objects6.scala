object Container {
  def hello = println("hello")
  val hi: T = "Hi"
  var x: T = "?"
  type T = String
  object Welcome {
    def welcome = "Welcome" + x
  }
  class Greeting(name: String) {
    def greet = println("Hello "+name)
  }
}
