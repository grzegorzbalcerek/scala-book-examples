object select {
  def either[A](a: => A) = new {
    import scala.util.Random
    def or[B >: A](b: => B) = if (Random.nextBoolean) a else b
  }
}
