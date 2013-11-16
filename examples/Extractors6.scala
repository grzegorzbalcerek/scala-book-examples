object HasUpperCase2 {
  def unapply(x: Any): Option[(Char,Char)] = x match {
    case s: String if s.count(_.isUpper) == 2 =>
      val u = s.filter(_.isUpper)
      Some((u(0),u(1)))
    case _ => None
  }
}
