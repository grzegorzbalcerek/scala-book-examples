object EitherOr2 {
  def either[A](a: => A) = new {
    import scala.util.Random
    def or(b: => A) = if (Random.nextBoolean) a else b
  }
}
