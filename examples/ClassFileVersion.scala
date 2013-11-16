import scala.util.parsing.combinator.Parsers
object ClassFileVersion extends Parsers {
  override type Elem = Byte
  def main(args: Array[String]) =
    println(classfile(ClassFileReader(args(0))) match {
      case Success(result, _) => result
      case NoSuccess(msg, _) => "Not a valid classfile: "+msg })
  def classfile = magic ~> major ~ minor ^^
    {case x~y => "Classfile with major number "+ x + " and minor number " + y}
  implicit def int2literal(n: Int) = elem(n.toByte)
  def magic = accept(List(0xCA,0xFE,0xBA,0xBE).map(_.toByte))
  def major = twoBytes
  def minor = twoBytes
  def twoBytes = byte ~ byte ^^ {case a~b => 256*a + b}
  def byte = elem("a byte",_ => true)
}
import scala.util.parsing.input.{Reader, NoPosition}
object ClassFileReader {
  def apply(file: String) = {
    import java.io.{File, FileInputStream}
    val fis = new FileInputStream(new File(file))
    val data = Array.ofDim[Byte](file.length)
    fis.read(data)
    fis.close
    new ClassFileReader(data.toList)
  }
}
class ClassFileReader(bytes: List[Byte]) extends Reader[Byte] {
  def first = bytes.head
  def rest = new ClassFileReader(bytes.tail)
  def pos = NoPosition
  def atEnd = bytes.isEmpty
}
