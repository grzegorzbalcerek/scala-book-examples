implicit class NewLinesString(sc: StringContext) {
  def nl(args: Any*): String = {
    val sb = new StringBuilder()
    var j = 0
    while (j < args.size) {
      sb append sc.parts(j)
      sb append args(j)
      sb append "\n"
      j += 1
    }
    sb append sc.parts(j)
    sb.toString
  }
}
