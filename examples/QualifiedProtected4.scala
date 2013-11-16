package hello {
  class Greeting(greeting: String) {
    protected def speak = println(greeting)
  }
  object Hello {
    def speak = new Greeting("Hello!!!!").speak
  }
}
