object HasUpperCase3 {
  def unapply(x: Any): Boolean = x match {
    case s: String => s.exists(_.isUpper)
    case _ => false
  }
}
