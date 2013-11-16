package b
import a._
object A { override def toString = "b.A" }
object Bindings2 extends App {
  println(A)
}
