object RedPaper extends ColorPaper("red")
object RedPaperBox extends Box("red paper box", RedPaper)
class ExistentialDrawingChild4a(name: String,
  box: Box[T] forSome { type T <: RedPaper.type}) {
  def draw = {
    val paper = box.take
    println("Drawing on "+paper)
  }
  override def toString = name
}
class ExistentialDrawingChild4b(name: String,
  box: Box[x.type] forSome {val x: RedPaper.type}) {
  def draw = {
    val paper = box.take
    println("Drawing on "+paper)
  }
  override def toString = name
}
