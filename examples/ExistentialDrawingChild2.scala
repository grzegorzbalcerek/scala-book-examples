class ExistentialDrawingChild2(name: String,
  box: Box[_ <: Paper],
  wasteBin: WasteBin[_ >: Paper]) {
  def draw = {
    val paper = box.take
    println("Drawing on "+paper)
    wasteBin.throwAway(paper)
  }
  override def toString = name
}
