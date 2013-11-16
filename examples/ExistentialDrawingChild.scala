class ExistentialDrawingChild(name: String,
  box: Box[A] forSome { type A <: Paper },
  wasteBin: WasteBin[B] forSome { type B >: Paper }) {
  def draw = {
    val paper = box.take
    println("Drawing on "+paper)
    wasteBin.throwAway(paper)
  }
  override def toString = name
}
