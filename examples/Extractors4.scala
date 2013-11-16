object HasUpperCase4 {
  def unapply(s: String): Boolean = s.exists(_.isUpper)
  def unapply(x: Any): Boolean = false
}
