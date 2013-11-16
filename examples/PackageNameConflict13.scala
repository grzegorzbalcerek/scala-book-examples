package greetings {
  object hello {
    def speak = println("Hello!")
  }
  package hello {
    object speak {
      println("Hello!!!")
    }
  }
}
