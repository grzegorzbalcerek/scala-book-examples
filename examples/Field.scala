package chess

case class Field(col: Int, row: Int) {
  override def toString = (col + 'a' - 1).toChar.toString + row
  def relative(c: Int, r: Int) = Field(col+c, row+r)
  def isLastRow(color: Color) = row == color.other.firstRow
  def isValid = col >= 1 && col <= 8 && row >= 1 && row <= 8
}
