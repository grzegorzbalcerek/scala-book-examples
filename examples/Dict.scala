import scala.xml._
import transform._
class Dict(file: String) {
  val dict = XML.loadFile(file)
  def translate(word: String, from: String, to: String) =
    dict \\ "entry" find (entry =>
        (entry \ from \ "word" text) == word) match {
      case Some(entry) =>
        def translation(lang: String) =
          (entry \ lang \ "word" text) +
          (entry \ lang \ "gender" map (" ("+_.text+")")).mkString
        translation(from) + " - " + translation(to)
      case None =>
        word + ": translation not found"
    }
}

