object HasUpperCase {
  def unapply(x: Any): Option[String] = x match {
    case s: String if s.exists(_.isUpper) => Some(s.filter(_.isUpper))
    case _ => None
  }
}
