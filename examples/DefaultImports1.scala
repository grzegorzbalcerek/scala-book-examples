object DefaultImports1 {
  def main(args: scala.Array[java.lang.String]) {
    val time = java.lang.System.nanoTime
    val option: scala.Option[scala.Long] = scala.Some(time)
    scala.Predef.assume(option != scala.None)
    scala.Predef.println("Hi!")
  }
}
