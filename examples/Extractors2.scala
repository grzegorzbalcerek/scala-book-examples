object HasUpperCase2 {
  def unapply(s: String): Boolean = s.exists(_.isUpper)
  def unapply(s: Int): Boolean = false
}
