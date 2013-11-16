class WasteBin[T](name: String) {
  def throwAway(t: T) =
    println("Throwing away "+t+" into the "+this)
  override def toString = name
}
