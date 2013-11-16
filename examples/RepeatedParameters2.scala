def arguments(msg: String = "arguments:", args: String*):String = {
  def argString(as: Seq[String]): String =
    if (as.isEmpty) "" else " " + as.head + argString(as.tail)
  msg + argString(args)
}
