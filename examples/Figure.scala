package chess

abstract sealed class FigureType
case object King extends FigureType
case object Queen extends FigureType
case object Rook extends FigureType
case object Bishop extends FigureType
case object Knight extends FigureType
case object Pawn extends FigureType

case class Figure(figureType: FigureType, figureColor: Color) {
  override def toString = (figureType, figureColor) match {
    case (King,   White) => "k"
    case (Queen,  White) => "q"
    case (Rook,   White) => "r"
    case (Bishop, White) => "b"
    case (Knight, White) => "n"
    case (Pawn,   White) => "p"
    case (King,   Black) => "K"
    case (Queen,  Black) => "Q"
    case (Rook,   Black) => "R"
    case (Bishop, Black) => "B"
    case (Knight, Black) => "N"
    case (Pawn,   Black) => "P"
  }
  def figureSymbol = (figureType, figureColor) match {
    case (King,   White) => "\u2654"
    case (Queen,  White) => "\u2655"
    case (Rook,   White) => "\u2656"
    case (Bishop, White) => "\u2657"
    case (Knight, White) => "\u2658"
    case (Pawn,   White) => "\u2659"
    case (King,   Black) => "\u265a"
    case (Queen,  Black) => "\u265b"
    case (Rook,   Black) => "\u265c"
    case (Bishop, Black) => "\u265d"
    case (Knight, Black) => "\u265e"
    case (Pawn,   Black) => "\u265f"
  }
}
