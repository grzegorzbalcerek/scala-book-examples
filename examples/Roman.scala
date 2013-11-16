import java.util._
import scala.language.implicitConversions
object Roman {
  implicit class RomanWrapper(val d: Int) extends AnyVal {
    def mkDate(y: Int, m: Int) =
      new GregorianCalendar(y, m-1, d).getTime
    def I   (y: Int) = mkDate(y, 1)
    def II  (y: Int) = mkDate(y, 2)
    def III (y: Int) = mkDate(y, 3)
    def IV  (y: Int) = mkDate(y, 4)
    def V   (y: Int) = mkDate(y, 5)
    def VI  (y: Int) = mkDate(y, 6)
    def VII (y: Int) = mkDate(y, 7)
    def VIII(y: Int) = mkDate(y, 8)
    def IX  (y: Int) = mkDate(y, 9)
    def X   (y: Int) = mkDate(y, 10)
    def XI  (y: Int) = mkDate(y, 11)
    def XII (y: Int) = mkDate(y, 12)
  }
}
