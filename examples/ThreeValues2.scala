case class ThreeValues2[T](a: T, b: T, c: T) {
  def foreach(f: T => Unit) { f(a); f(b); f(c) }
  def map[S](f: T => S) = new ThreeValues2(f(a), f(b), f(c))
}
