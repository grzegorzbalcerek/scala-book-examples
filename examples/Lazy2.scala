class Lazy2 {
  println("constructor - start")
  val b = a
  println("in constructor")
  lazy val a = { println("initializing a"); 1 }
  println("constructor - stop")
}
