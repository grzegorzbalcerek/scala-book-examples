class Lazy3 {
  println("constructor - start")
  lazy val b = { println("initializing b"); a }
  println("in constructor")
  lazy val a = { println("initializing a"); 1 }
  println("constructor - stop")
}
