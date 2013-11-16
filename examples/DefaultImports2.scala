object DefaultImports2 {
  def main(args: Array[String]) {
    val time = System.nanoTime
    val option: Option[Long] = Some(time)
    assume(option != None)
    println("Hi!")
  }
}
