class Hi1 {
  def greet = println("Hi1")
}
class Hi2 {
  def greet = println("Hi2")
}
class Hi3 extends Hi1 {
  override def greet = println("Hi3")
  class Hi4 extends Hi2 {
    override def greet = println("Hi4")
    def talk = {
      this.greet
      Hi3.this.greet
      super.greet
      Hi3.super.greet
    }
  }
}
