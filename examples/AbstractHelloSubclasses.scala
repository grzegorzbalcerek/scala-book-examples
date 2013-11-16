class Hello1 extends AbstractHello {
  type T = String
  val hello = "Hello"
  var name: T = "Peter"
  def greet = hello + " " + name
}
class Hello2 extends AbstractHello {
  override type T = String
  override val hello = "Hello"
  override var name: T = "Peter"
  override def greet = hello + " " + name
}
