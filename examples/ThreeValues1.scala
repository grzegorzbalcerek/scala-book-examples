case class ThreeValues1[T](a: T, b: T, c: T) {
  def foreach(f: T => Unit) { f(a); f(b); f(c) }
}
