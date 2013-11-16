class DrawingChild(name: String,
  box: Box[Paper],
  wasteBin: WasteBin[Paper]){
  def draw = {
    val paper = box.take
    println("Drawing on "+paper)
    wasteBin.throwAway(paper)
  }
  override def toString = name
}
