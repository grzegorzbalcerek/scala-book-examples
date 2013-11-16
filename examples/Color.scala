package chess

abstract sealed class Color {
  def other: Color
  def firstRow: Int
}

case object White extends Color {
  def other = Black
  def firstRow = 1
}

case object Black extends Color {
  def other = White
  def firstRow = 8
}
