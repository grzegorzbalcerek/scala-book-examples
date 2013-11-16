import scala.xml._
def f(node: Node) = node match {
  case <a/> => "Empty node a"
  case <b></b> => "Empty node b"
  case <c>{_}</c> => "Node c with a child"
  case <d>{x}</d> => "Node d with the following child: "+x
  case <e>{x @ _*}</e> => "Node e with the following content "+x
  case _ => "not matched"
}
