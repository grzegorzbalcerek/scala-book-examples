object Welcome {
  val a = "Welcome!"
}
object Bindings9 {
  val a = "Welcome!!"
  def welcome {
    import Welcome.a
    println(a)
  }
}
