object isSmaller extends ((Int,Int) => Boolean) {
  def apply(a: Int, b:Int): Boolean = a < b
}
object isSmaller2 extends ((Int,Int) ⇒ Boolean) {
  def apply(a: Int, b:Int): Boolean = a < b
}
