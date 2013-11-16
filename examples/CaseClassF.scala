case class F()
def testF(x: Any):String = x match {
  case F() => "F matched"
  case _ => "not F"
}
