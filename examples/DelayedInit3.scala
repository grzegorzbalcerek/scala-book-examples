class DelayedInit3 extends DelayedInit {
  println("in constructor")
  var initialization: () => Unit = () => println("initialization")
  override def delayedInit(body: => Unit) {
    initialization = () => body
  }
}
