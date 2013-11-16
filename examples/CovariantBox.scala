class CovariantBox[+T](name: String, e: T) {
  def take: T = {
    println("Taking "+e+" from the "+this)
    e
  }
  override def toString = name
}
