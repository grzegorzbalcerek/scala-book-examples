import scala.xml._
def g(node: Node) = node match {
  case Elem(_,"a",_,_) => "Empty node a"
  case Elem(_,"b",_,_,Text(t)) => "Element b with a text node: "+t
  case Comment(x) => "Comment: "+x
  case ProcInstr("p",_) => "Processing instruction p"
  case <d>{ EntityRef(x) }</d> => "Node d with entity: "+x
  case _ => "not matched"
}
