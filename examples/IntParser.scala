import scala.util.parsing.combinator.Parsers
import scala.util.parsing.input.CharSequenceReader
object IntParser extends Parsers {
  type Elem = Char
  def digit = elem("a digit (character between '0' and '9')",
                   (c => c >= '0' && c <= '9')) ^^ (_ - '0')
  def digits = rep1(digit) ^^ (numbers => (0 /: numbers)((a,b) => 10*a+b))
  def sign = elem('+') ^^^ 1 | elem('-') ^^^ -1
  def intNumber = opt(sign)~digits ^^ {
    case Some(s)~num => s*num
    case None~num => num
  }
  def apply(str: String): Either[String,Int] = {
    import scala.util.parsing.input.CharSequenceReader
    val input = new CharSequenceReader(str)
    intNumber(input) match {
      case Success(num, _) => Right(num)
      case NoSuccess(msg, remainder) =>
        Left(msg + " at " +  remainder.pos +
          " instead of " + remainder.first)
    }
  }
}
