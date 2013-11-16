trait PersonGreeting2 extends Greeting { this: Person =>
  override def greet = super.greet + " " + this.name
}
