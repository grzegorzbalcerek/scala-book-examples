object HasUpperCase1 {
  def unapply(s: String): Boolean = s.exists(_.isUpper)
}
