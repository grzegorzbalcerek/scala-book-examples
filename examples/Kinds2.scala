object ListInstance extends StringInstance[List] {
  def mkInstance(s: String): List[String] = List(s)
}
