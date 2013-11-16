import scala.util.parsing.combinator._
object DictTxtToXml1 extends RegexParsers {
  def dictionary:    Parser[Any] = rep(entry)
  def entry:         Parser[Any]      = partOfSpeech~translations
  def partOfSpeech:  Parser[Any] =
    literal("[")~(literal("noun")|literal("verb"))~literal("]")
  def translations:  Parser[Any] = enTranslation~"-"~frTranslation
  def enTranslation: Parser[Any] = word
  def frTranslation: Parser[Any] = word~opt(gender)
  def gender:        Parser[Any] = literal("(")~regex("""\w""".r)~literal(")")
  def word:          Parser[Any] = regex("""\w+""".r)
}
