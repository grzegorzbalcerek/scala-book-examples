trait DoubleGreeting extends AbstractGreeting {
  abstract override def greeting =
    super.greeting + " " + super.greeting
}
