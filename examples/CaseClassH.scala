case class H(z: Int*)
def testH(x: Any) = x match {
  case H() => "H()"
  case H(_) => "H(?)"
  case H(1,_) => "H(1,?)"
  case H(_,_) => "H(?,?)"
  case H(_,_,_) => "H(?,?,?)"
  case _:H => "H(?,?,?,?*)"
  case _ => "not H"
}
