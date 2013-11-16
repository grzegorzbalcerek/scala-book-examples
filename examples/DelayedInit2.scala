class DelayedInit2 extends DelayedInit {
  println("in constructor")
  var initialization: () => Unit = _
  override def delayedInit(body: => Unit) {
    initialization = () => body
  }
}
