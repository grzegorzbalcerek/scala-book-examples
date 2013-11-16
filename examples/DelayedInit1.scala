class DelayedInit1 extends DelayedInit {
  println("in constructor")
  override def delayedInit(body: => Unit) { body; body }
}
