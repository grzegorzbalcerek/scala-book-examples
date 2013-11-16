final class Loop {
  def repeat(n: Int)(body: => Unit) {
    body
    if (n > 1) repeat(n-1)(body)
  }
}
