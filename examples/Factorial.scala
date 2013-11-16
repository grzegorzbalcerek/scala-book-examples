import scala.language.implicitConversions
object Factorial {
  implicit class FactorialWrapper(val n: Int) extends AnyVal {
    def ! = (1 to n).product
  }
}
