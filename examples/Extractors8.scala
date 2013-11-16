object HasUpperCase {
  def unapplySeq(x: Any): Option[(Char,Char,Seq[Char])] = x match {
    case s: String if s.count(_.isUpper) >= 2 =>
      val head1 = s.filter(_.isUpper).head
      val head2 = s.filter(_.isUpper).tail.head
      val tail = s.filter(_.isUpper).tail.tail
      Some((head1,head2,tail))
    case _ => None
  }
}
