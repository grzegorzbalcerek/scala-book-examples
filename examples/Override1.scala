class X1 {
  def a: Any = 'a
  def b: Any = 'b
}
class Y1 extends X1 {
  override def a: String = "a"
  override val b: String = "b"
}
