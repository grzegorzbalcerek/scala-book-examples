object Hi {
  val a = "Hi!"
}
object Bindings7 extends App {
  def hi {
    import Hi.a
    val a = "Hi!!"
    println(a)
  }
  hi
}
