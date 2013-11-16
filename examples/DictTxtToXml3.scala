import scala.util.parsing.combinator._
object DictTxtToXml3 extends RegexParsers {
  def dictionary:    Parser[Any] = rep(entry)
  def entry:         Parser[Any] = partOfSpeech into { part => translations(part) }
  def partOfSpeech:  Parser[Any] = "["~>("noun"|"verb")<~"]"
  def translations(part: String): Parser[Any] = enTranslation~"-"~frTranslation(part)
  def enTranslation: Parser[Any] = "en:"~word
  def frTranslation(part: String): Parser[Any] = part match {
    case "noun" => word~gender
    case "verb" => word
  }
  def gender:        Parser[Any] = "("~"""\w""".r~")"
  def word:          Parser[Any] = """\w+""".r
}
