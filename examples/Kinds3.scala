object OptionInstance extends StringInstance[Option] {
  def mkInstance(s: String): Option[String] = Some(s)
}
