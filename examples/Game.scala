package chess
import compat.Platform.EOL
import Board._
import FigureMoves._

abstract sealed class Game {
  val color: Color
  val hist: List[Game]
  val board: Board

  def updated(move: Move) =
    new OngoingGame(color.other,
      Board.updateBoard(board, move),
      this :: hist,
      move)

  def move(from: Field, to: Field, promotion: Option[Figure] = None) = {
    def isMatching(game: OngoingGame) =
      game.lastMove.from == from &&
      game.lastMove.to == to &&
      (game.lastMove match {
        case PromotionMove(_,_,prom) => Some(prom) == promotion
        case _ => promotion == None })
    validGames.filter(isMatching).toList.headOption
  }

  def validGames = nextGames.filter{ g => !g.isOtherKingUnderCheck }

  def nextGames =
    board.iterator.
      filter{ case (_, figure) => figure.figureColor == color }.
      flatMap{ case (from, figure) => 
        figure.figureType match {
          case Rook | Bishop | Queen | Knight | King =>
            val fieldss = figureMoves(figure,from,false)
            val gamesAfterRegularMoves =
              (freeDestinations(fieldss) ++ captureDestinations(fieldss)).
                map(to => updated(RegularMove(from,to)))
            val gamesAfterCastlingMoves =
              if (figure.figureType == King) castling(3,1,4,2)++castling(7,8,6,7)
              else Seq()
            gamesAfterRegularMoves ++ gamesAfterCastlingMoves
          case Pawn =>
            val regularAndPromotionMoves =
              (captureDestinations(figureMoves(figure,from,true))++
                freeDestinations(figureMoves(figure,from,false))).
                flatMap(to =>
                  if (to.isLastRow(color))
                    Seq(Figure(Queen,color),Figure(Rook,color),Figure(Bishop,color),Figure(Knight,color)).
                    map(figure => updated(PromotionMove(from,to,figure)))
                  else Seq(updated(RegularMove(from,to))))
            val enPassantMoves =
              freeDestinations(figureMoves(figure,from,true)).
                filter(isEnPassantCapture(from,_)).map(to =>
                  updated(EnPassantMove(from, to, Field(to.col,from.row))))
            regularAndPromotionMoves ++ enPassantMoves
          case _ => Seq.empty
        }
      }

  def isOtherKingUnderCheck: Boolean = {
    def isKingOnBoard(g: Game) = g.board.values.exists(fig => fig == Figure(King,color.other))
    !nextGames.forall(isKingOnBoard)
  }

  def freeDestinations(fieldss: Seq[Seq[Field]]) =
    fieldss.flatMap(fields => fields.takeWhile(isFieldEmpty))

  def captureDestinations(fieldss: Seq[Seq[Field]]) = {
    def hasEnemyFigure(field: Field) =
      board.get(field).map(_.figureColor) == Some(color.other)
    fieldss.flatMap(_.dropWhile(isFieldEmpty).take(1).filter(hasEnemyFigure))
  }

  def defendedDestinations(fieldss: Seq[Seq[Field]]) = {
    def hasSameColorFigure(field: Field) =
      board.get(field).map(_.figureColor) == Some(color)
    fieldss.flatMap(_.dropWhile(isFieldEmpty).take(1).filter(hasSameColorFigure))
  }

  def castling(kingTo: Int, rookFrom: Int, rookTo: Int, otherCol: Int) = {
    val row = color.firstRow
    if (board.get(Field(4,row)) == Some(Figure(King,color)) &&
        board.get(Field(rookFrom,row)) == Some(Figure(Rook,color)) &&
        board.get(Field(rookTo,row)) == None &&
        board.get(Field(kingTo,row)) == None &&
        board.get(Field(otherCol,row)) == None &&
        hist.forall(_.board.get(Field(4,row)) == Some(Figure(King,color))) &&
        hist.forall(_.board.get(Field(rookFrom,row)) == Some(Figure(Rook,color))) &&
        !updated(RegularMove(Field(4,row),Field(rookTo,row))).isOtherKingUnderCheck)
      Seq(updated(CastlingMove(Field(4,row), Field(kingTo,row),
        Field(rookFrom,row), Field(rookTo,row))))
    else Seq()
  }

  def isFieldEmpty(field: Field): Boolean =
    !board.contains(field)

  def isEnPassantCapture(from: Field, to: Field) = this match {
    case GameStart => false
    case g:OngoingGame =>
      g.board.get(g.lastMove.to) == Some(Figure(Pawn,color.other)) &&
      g.lastMove.to == Field(to.col, from.row) &&
      g.lastMove.from == Field(to.col, from.row + 2*(to.row-from.row))
  }

  def isKingUnderCheck: Boolean =
    new OngoingGame(color.other, board, this :: hist,
      RegularMove(Field(0,0),Field(0,0))).isOtherKingUnderCheck

  def isGameFinished: Boolean =
    nextGames.forall(_.isOtherKingUnderCheck) ||
    Set[Set[Figure]](Set(Figure(King,White),Figure(King,Black)),
                     Set(Figure(King,White),Figure(King,Black),Figure(Bishop,White)),
                     Set(Figure(King,White),Figure(King,Black),Figure(Bishop,Black)),
                     Set(Figure(King,White),Figure(King,Black),Figure(Knight,White)),
                     Set(Figure(King,White),Figure(King,Black),Figure(Knight,Black)),
                     Set(Figure(King,White),Figure(King,Black),Figure(Knight,White),Figure(Knight,White)),
                     Set(Figure(King,White),Figure(King,Black),Figure(Knight,Black),Figure(Knight,Black))).
      contains(board.values.toSet) ||
      !(board :: hist.map(_.board)).
        groupBy(identity).values.toSet.filter(_.size >= 3).isEmpty

  def winner: Option[Color] = if (isGameFinished && isKingUnderCheck)
    Some(color.other) else None

}

object GameStart extends Game {
  override val color = White
  override val hist: List[Game] = Nil
  override val board = startingBoard
  override def toString = "White to begin:\n"+showBoard(board)
}

final class OngoingGame(
  override val color: Color,
  override val board: Board,
  override val hist: List[Game],
  val lastMove: Move
) extends Game {
  override def toString = "Last move: "+color.other+" "+
    lastMove.from+" to "+lastMove.to+EOL+showBoard(board)
}
