trait Show[T] { def show(x: T):String }
object Show {
  implicit object ShowDouble extends Show[Double] {
    def show(x:Double) = f"$x%.2f"
  }
  implicit object ShowSymbol extends Show[Symbol] {
    def show(x:Symbol) = ":" + x.name
  }
}
object ShowUtil {
  def print1[T](value: T)(implicit s: Show[T]) = print(s.show(value))
  def print2[T : Show](value: T) =
    print(implicitly[Show[T]].show(value))
}
