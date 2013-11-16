package chess

object FigureMoves {
  import collection.immutable._, Stream._
  def rookMoves: Seq[(Stream[Int],Stream[Int])] =
    Seq((from(1,1),continually(0)),
        (from(-1,-1),continually(0)),
        (continually(0),from(1,1)),
        (continually(0),from(-1,-1)))
  def bishopMoves: Seq[(Stream[Int],Stream[Int])] =
    Seq((from(1,1),from(1,1)),
        (from(-1,-1),from(1,1)),
        (from(1,1),from(-1,-1)),
        (from(-1,-1),from(-1,-1)))
  def queenMoves: Seq[(Stream[Int],Stream[Int])] = rookMoves ++ bishopMoves
  def knightMoves: Seq[(Stream[Int],Stream[Int])] =
    Seq((Stream(1),Stream(2)),
        (Stream(2),Stream(1)),
        (Stream(-1),Stream(2)),
        (Stream(2),Stream(-1)),
        (Stream(-1),Stream(-2)),
        (Stream(-2),Stream(-1)),
        (Stream(1),Stream(-2)),
        (Stream(-2),Stream(1)))
  def kingMoves: Seq[(Stream[Int],Stream[Int])] =
    queenMoves.map{case (a,b) => (a.take(1),b.take(1)) }
  def chooseFigureMoves(figure: Figure, field: Field, capture: Boolean): Seq[(Stream[Int],Stream[Int])] =
    figure.figureType match {
      case Rook => rookMoves
      case Bishop => bishopMoves
      case Queen => queenMoves
      case King => kingMoves
      case Knight => knightMoves
      case Pawn => capture match {
        case false => figure.figureColor match {
          case White => if (field.row == 2) Seq((continually(0),Stream(1,2)))
                        else Seq((Stream(0),Stream(1)))
          case Black => if (field.row == 7) Seq((continually(0),Stream(-1,-2)))
                        else Seq((Stream(0),Stream(-1))) }
        case true =>  figure.figureColor match {
          case White => Seq((Stream(-1),Stream(1)),(Stream(1),Stream(1)))
          case Black => Seq((Stream(-1),Stream(-1)),(Stream(1),Stream(-1))) } } }
  def relativeField(field: Field)(cr: (Int,Int)): Field =
    Field(field.col+cr._1, field.row+cr._2)
  def relativeFields(field: Field)(colsRows: (Stream[Int],Stream[Int])): Stream[Field] =
    colsRows._1.zip(colsRows._2).map(relativeField(field)).takeWhile(_.isValid)
  def figureMoves(figure: Figure, field: Field, capture: Boolean): Seq[Stream[Field]] =
    chooseFigureMoves(figure, field, capture).map(relativeFields(field))
}
