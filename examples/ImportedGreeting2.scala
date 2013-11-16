package greetings1 {
  package object hello {
    def greet = println("Hello!")
  }
}
package greetings2 {
  package object hello {
    def greet = println("Hello!!")
  }
}
object ImportedGreeting2 {
  def main(args: Array[String]) {
    import greetings1.hello._
    import greetings2.hello._
    greet
  }
}
