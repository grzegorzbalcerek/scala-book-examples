package hello {
  class Greeting(greeting: String) {
    protected[hello] def speak = println(greeting)
  }
  object Hello {
    def speak = new Greeting("Hello!!!!").speak
  }
}
