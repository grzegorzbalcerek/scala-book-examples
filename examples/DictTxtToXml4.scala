import scala.util.parsing.combinator._
object DictTxtToXml4 extends RegexParsers {
  def dict = rep(entry) ^^ { entries => <dict>{ entries }</dict>}
  def entry = partOfSpeech into { part => translations(part) }
  def partOfSpeech = "["~>("noun"|"verb")<~"]"
  def translations(part: String) = enTranslation~"-"~frTranslation(part) ^^ {
    case e~_~f => <entry kind={part}>{e}{f}</entry>
  }
  def enTranslation = word ^^ (x => <en>{ x }</en>)
  def frTranslation(part: String) = part match {
    case "noun" => word~gender ^^ { case w~g => <fr>{ w }{ g }</fr> }
    case "verb" => word        ^^ ( w => <fr>{ w }</fr> )
  }
  def gender = "("~>"""\w""".r<~")" ^^ (x => <gender>{ x }</gender>)
  def word   = """\w+""".r ^^ {w => <word>{ w }</word>}
}
