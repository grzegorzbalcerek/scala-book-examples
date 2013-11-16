def timeTest(body1: => Unit, body2: => Unit, n: Int) = {
  def time(body: => Unit) = {
    val t=System.nanoTime
    body
    System.nanoTime-t
  }
  var j = 0;
  var time1 = 0L
  var time2 = 0L
  while (j < n) {
    time1 += time(body1)
    time2 += time(body2)
    j += 1
  }
  (time1/1000000000, time2/1000000000)
}
