import scala.util.parsing.combinator._
object DictTxtToXml2 extends RegexParsers {
  def dict:          Parser[Any] = rep(entry)
  def entry:         Parser[Any] = partOfSpeech~translations
  def partOfSpeech:  Parser[Any] = "["~("noun"|"verb")~"]"
  def translations:  Parser[Any] = enTranslation~"-"~frTranslation
  def enTranslation: Parser[Any] = word
  def frTranslation: Parser[Any] = word~opt(gender)
  def gender:        Parser[Any] = "("~"""\w""".r~")"
  def word:          Parser[Any] = """\w+""".r
}
