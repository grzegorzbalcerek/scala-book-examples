import scala.io.Source
import scala.xml.pull._
object EnglishVerbs {
  def main(args: Array[String]) {
    val source = Source.fromFile("dict.xml")
    val reader = new XMLEventReader(source)
    var inVerbEntry = false
    var inEn = false
    var inWord = false
    while(reader.hasNext) {
      reader.next match {
        case EvElemStart(_,"entry", attr, _)
          if attr.get("kind").exists(_.text == "verb") => inVerbEntry = true
        case EvElemStart(_,"en", _, _) => inEn = true
        case EvElemStart(_,"word", _, _) => inWord = true
        case EvText(txt) if inVerbEntry && inEn && inWord => print(txt)
        case EvElemEnd(_,"word") =>
          if (inVerbEntry && inEn && inWord) println()
          inWord = false
        case EvElemEnd(_,"en") => inEn = false
        case EvElemEnd(_,"entry") => inVerbEntry = false
        case _ =>
      }
    }
  }
}
