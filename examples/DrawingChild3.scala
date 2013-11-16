class DrawingChild3(name: String,
  box: Box[Paper],
  wasteBin: ContravariantWasteBin[Paper]) {
  def draw = {
    val paper = box.take
    println("Drawing on "+paper)
    wasteBin.throwAway(paper)
  }
  override def toString = name
}
