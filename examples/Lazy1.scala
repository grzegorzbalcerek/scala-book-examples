class Lazy1 {
  println("constructor - start")
  lazy val a = { println("initializing a"); 1 }
  println("constructor - stop")
}
