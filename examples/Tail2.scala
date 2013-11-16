class Loops2 {
  def repeat2(n: Int, body: => Unit) {
    body
    if (n > 1) repeat2(n-1, body)
  }
}
