final class Loops {
  def repeat1(n: Int, body: => Unit) {
    if (n > 1) repeat1(n-1, body)
    body
  }
  def repeat2(n: Int, body: => Unit) {
    body
    if (n > 1) repeat2(n-1, body)
  }
}
