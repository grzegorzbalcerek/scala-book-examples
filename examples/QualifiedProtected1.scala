package hello {
  class Greeting(greeting: String) {
    private[hello] def speak = println(greeting)
  }
  object Hello {
    def speak = new Greeting("Hello!!!!").speak
  }
}
