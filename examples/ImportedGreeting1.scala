package greetings {
  package object hello {
    def greet = println("Hello!")
  }
  package object hi {
    def greet = println("Hi!")
  }
  package object welcome {
    def greet = println("Welcome!")
  }
}
object ImportedGreeting1 {
  def main(args: Array[String]) {
    import greetings._
    if (args.length == 0) {
      import welcome._
      greet
    }
    else args(0) match {
      case "Peter" =>
        import hello._
        greet
      case _ =>
        import hi._
        greet
    }
  }
}
