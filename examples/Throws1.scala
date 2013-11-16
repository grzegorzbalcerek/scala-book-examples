class Throws1 {
  @throws(classOf[Exception])
  @throws(classOf[IllegalArgumentException])
  def greet(greeting: String, n: Int) {
    if (n < 0) throw new IllegalArgumentException(
        "The number of repetitions must be positive.")
    if (n > 5) throw new Exception("Too many repetitions requested: "+n)
    for (j <- 1 to n) println(greeting)
  }
}
