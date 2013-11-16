object UnlessOtherwise {
  def unless(cond: Boolean)(u: => Unit) = {
    if (!cond) u
    new { def otherwise(o: => Unit) = if (cond) o }
  }
}
