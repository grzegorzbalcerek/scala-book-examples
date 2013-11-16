object HasUpperCase {
  def unapplySeq(x: Any): Option[Seq[Char]] = x match {
    case s: String if s.exists(_.isUpper) =>
      Some(s.filter(_.isUpper).toSeq)
    case _ => None
  }
}
