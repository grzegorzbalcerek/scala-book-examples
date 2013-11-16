object EitherOr1 {
  def either(a: => Unit) = new {
    import scala.util.Random
    def or(b: => Unit) = if (Random.nextBoolean) a else b
  }
}
