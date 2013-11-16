class ClassParametersRepeated(args: String*) {
  def arguments = argString(args)
  def argString(as: Seq[String]): String =
    if (as.isEmpty) ""
    else as.head + " " + argString(as.tail)
}
