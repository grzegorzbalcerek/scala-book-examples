object Synch {
  def main(args: Array[String]) {
    val lock = new AnyRef
    var value = 0
    class Increment(remainder: Int) extends Thread {
      override def run() {
        var j = 0
        while (j < 4) {
          lock.synchronized {
            if (value % 2 == remainder) {
              value += 1
              println("Increment(" + remainder +
                      "): new value = " + value)
              j += 1
              lock.notify()
            }
            else lock.wait()
          }
        }
      }
    }
    val inc0 = new Increment(0)
    val inc1 = new Increment(1)
    inc0.start()
    inc1.start()
  }
}
