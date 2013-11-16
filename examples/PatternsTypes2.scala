class A { class B }
class D
trait E
def typePattern2(value: Any):String =
  value match {
    case _ :scala.Symbol => "Symbol matched"
    case _ :A#B => "A#B matched"
    case _ :None.type => "None.type matched"
    case _ :D with E => "D with E matched"
    case _ => "Not matched"
  }
