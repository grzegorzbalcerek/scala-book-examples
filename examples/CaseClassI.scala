case class I(x: Int, y: Int, z: String*)
def testI(x: Any) = x match {
  case I(1,_) => "I(1,?)"
  case I(_,_) => "I(?,?)"
  case I(_,_,_) => "I(?,?,?)"
  case _:I => "I(?,?,?,?*)"
  case _ => "not I"
}
