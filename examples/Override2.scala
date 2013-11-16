abstract class X2 {
  type A >: String <: Any
  def a: A
}
class Y2 extends X2{
  override type A = AnyRef
  def a: A = 'a
}
