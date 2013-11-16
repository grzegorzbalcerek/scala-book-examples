object Warnings extends App {
  implicit def f(x:Option[_]):A = x match {
    case _:Some[_] => new A
  }
  case class A { def aaaa = println("aaaa"); }
  Some(1).aaaa
}
