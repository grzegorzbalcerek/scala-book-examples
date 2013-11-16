class DrawingChild2(name: String,
  box: CovariantBox[Paper],
  wasteBin: WasteBin[Paper]) {
  def draw {
    val paper = box.take
    println("Drawing on "+paper)
    wasteBin.throwAway(paper)
  }
  override def toString = name
}
