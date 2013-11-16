class Paper {
  override def toString = "paper"
}
class ColorPaper(color: String) extends Paper {
  override def toString = color + " paper"
}
