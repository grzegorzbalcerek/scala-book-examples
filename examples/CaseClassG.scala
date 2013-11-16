case class G(x: Int, y: Int)
def testG(x: Any):String = x match {
  case G(1,_) => "G(1,?)"
  case G(_,_) => "G(?,?)"
  case _ => "not G"
}
