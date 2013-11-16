object VolatileTest1 {
  var x = 1L
  class UpdateThread(a: Long, b: Long) extends Thread {
      override def run {
        var k = 0
        while(k < 10000000){
          if (x != a && x != b) println("Wrong x value!")
          x = a
          k += 1
        }
      }
    }
  def main(args: Array[String]) {
    val t1 = new UpdateThread(1L,-1L)
    val t2 = new UpdateThread(-1L,1L)
    t1.start; t2.start
    t1.join; t2.join
  }
}
