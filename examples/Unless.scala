object Unless {
  def unless(cond: Boolean)(u: => Unit) = {
    if (!cond) u
  }
}
