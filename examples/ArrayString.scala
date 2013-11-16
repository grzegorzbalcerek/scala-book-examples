implicit class ArrayString(sc: StringContext) {
  def arr(args: Any*): Array[String] = sc.parts(0).split(" ")
}
