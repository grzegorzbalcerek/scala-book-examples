import scala.util.control.Exception._
val handler1 = catching(classOf[Exception]).opt[Int] _
val handler2 = (catching(classOf[ArithmeticException]) or
  catching(classOf[NullPointerException])).
  andFinally{ println("in finally") }.either[Int]_
