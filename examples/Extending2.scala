class Hello2 { def speak: String = "Hello" }
class Hi2 extends Hello2 {
  override def speak: String = "Hi"
  def hi: String = speak
}
class Speak2(override val speak: String) extends Hello2
