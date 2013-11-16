import scala.xml._
object DictXmlToTxt {
  def main(args: Array[String]) {
    val dict:Node = XML.loadFile("dict.xml")
    println(this(dict))
  }
  def apply(dict:Node) = {
    def convertEntries = for {
      entry <- dict \ "entry"
      val en = entry \ "en" \ "word" text
      val fr = entry \ "fr" \ "word" text
      val str = entry.attribute("kind") match {
        case Some(n) if n.text == "noun" =>
          val frGender = entry \ "fr" \ "gender" text;
          "[noun] " + en + " - " + fr + " (" + frGender + ")"
        case Some(n) if n.text == "verb" =>
          "[verb] " + en + " - " + fr
        case _ => ""
      }
    } yield str
    convertEntries.mkString("\n")
  }
}

