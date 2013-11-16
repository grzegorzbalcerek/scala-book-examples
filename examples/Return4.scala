def hello(n: Int): String = {
  val greet = (greeting: String, n: Int) => {
    if (n <= 0) return "wrong parameter value: "+n
    (greeting+" ") * n
  }
  val result =
    try greet("Hello!",n)
    catch { case ex: scala.runtime.NonLocalReturnControl[_] =>
              println("ex: "+ex); throw ex }
  println("returning: "+result)
  result
}
