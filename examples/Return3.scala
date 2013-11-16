def hello(n: Int): String = {
  val greet = (greeting: String, n: Int) => {
    if (n <= 0) return "wrong parameter value: "+n
    (greeting+" ") * n
  }
  val result = greet("Hello!",n)
  println("returning: "+result)
  result
}
