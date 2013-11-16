import scala.util.parsing.combinator._
import scala.xml._
import scala.io.Source
object DictTxtToXml extends RegexParsers {
  def main(args: Array[String]) = {
    val input = Source.fromFile("dict.txt").mkString
    this(input) match {
      case Right(result) => XML.save("dict.xml", result, "utf-8", true)
      case Left(errorMsg) => println("Error: " + errorMsg)
    }
  }
  def apply(input: String): Either[String, Node] = parseAll(dict, input) match {
    case Success(result, _) => Right(result)
    case NoSuccess(msg, _) => Left(msg)
  }
  def dict = rep(entry) ^^ { entries => <dict>{"\n"}{ entries }{"\n"}</dict>}
  def entry = partOfSpeech into { part => translations(part) }
  def partOfSpeech = "["~>("noun"|"verb")<~"]"
  def translations(part: String) = enTranslation~"-"~frTranslation(part) ^^ {
    case e~_~f => <entry kind={part}>{"\n"}{e}{f}{"\n"}</entry>
  }
  def enTranslation = word ^^ (x => <en>{ x }</en>)
  def frTranslation(part: String) = part match {
    case "noun" => word~gender ^^ { case w~g => <fr>{ w }{ g }</fr> }
    case "verb" => word        ^^ ( w => <fr>{ w }</fr> )
  }
  def gender = "("~>"""\w""".r<~")" ^^ (x => <gender>{ x }</gender>)
  def word   = """\w+""".r ^^ {w => <word>{ w }</word>}
}
