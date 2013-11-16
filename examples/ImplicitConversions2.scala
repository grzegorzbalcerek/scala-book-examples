class ImplicitConversions1 {
  implicit class any2either1[T](a: T) {
    def either: Either[T,T] = Left(a)
  }
}
object ImplicitConversions2 extends ImplicitConversions1
object ImplicitConversions3 extends ImplicitConversions1 {
  implicit class any2either3[T](a: T) {
    def either: Either[T,T] = Right(a)
  }
}
