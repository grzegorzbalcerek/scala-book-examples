object EitherOr3 {
  def either[A](a: => A) = new {
    import scala.util.Random
    def or[B](b: => B) = if (Random.nextBoolean) a else b
  }
}
