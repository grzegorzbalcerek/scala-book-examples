class Hello4(greeting: String) {
  println("Initializing class Hello4")
  def speak = println(greeting)
}
object Hi4 extends Hello4("Hi!!!!") {
  println("Initializing object Hi4")
}
