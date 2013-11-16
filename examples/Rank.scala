package chess

import language.implicitConversions

object Rank {

  def figureRank(figure: Figure) = figure.figureType match {
    case Queen => 900
    case Rook => 450
    case Knight | Bishop => 300
    case Pawn => 100
    case _ => 0
  }

  def fieldRank(field: Field) = {
    def colRowRank(cr: Int) = if (cr>=5) 9-cr else cr
    2*colRowRank(field.col) * colRowRank(field.row)
  }

  implicit def Game2Rank(game: Game): Rank = new Rank(game)

}

class Rank(game: Game) {
  import Rank._
  import FigureMoves._

  def figureDefendingOtherFiguresRank(field:Field, figure:Figure) =
    game.defendedDestinations(figureMoves(figure,field,true)).size/2

  def checkRank(color: Color) =
    if (game.color == color.other && game.isKingUnderCheck) 50
    else 0

  def colorRank(color: Color) =
    (for ((field, figure) <- game.board.iterator
      if figure.figureColor == color;
      r1 = figureRank(figure);
      r2 = fieldRank(field);
      r3 = game.figureDefendingOtherFiguresRank(field, figure))
    yield r1 + r2 + r3).sum + game.checkRank(color)

  def rank(color: Color) =
    game.colorRank(color)-game.colorRank(color.other)

}
