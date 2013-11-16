package hello {
  class Greeting(greeting: String) {
    protected[this] def speak = println(greeting)
  }
}
