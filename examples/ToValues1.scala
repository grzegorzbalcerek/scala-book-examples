import scala.util.control.Exception._
def div1(a: Int, b: Int) = catching(classOf[ArithmeticException]) opt a/b
def div2(a: Int, b: Int) = catching(classOf[ArithmeticException]) either a/b
