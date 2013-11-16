trait Exclamation {
  def exclamation = "!"
}
trait PersonGreeting3 extends Greeting { this: Person with Exclamation =>
  override def greet = super.greet + " " + this.name + this.exclamation
}
