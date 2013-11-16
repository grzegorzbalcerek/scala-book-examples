import scala.util.control.Exception._
def safe(c: => Int) = (catching(classOf[ArithmeticException]) or
                       catching(classOf[NumberFormatException])).
                       andFinally{ println("finally safe") }.either(c)
