abstract class X3 {
  type A <: Any
  type B >: String
  def c(a:A, b:B): Unit
}
abstract class Y3 extends X3 {
  override type A <: AnyRef
  override type B >: AnyRef
}
class Z3 extends Y3 {
  override type A = String
  override type B = Any
  override def c(a:String, b:Any) {
    println(a)
    println(b)
  }
}
