package greetings {
  object hello {
    def speak = println("Hello!")
  }
  package object hello {
    def speak = println("Hello!!")
  }
}
