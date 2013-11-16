import scala.util.parsing.input.CharSequenceReader
implicit def stringToReader(s: String) = new CharSequenceReader(s)
