import scala.annotation.ClassfileAnnotation
object WrongAnnotation {
  class author(final val name: String) extends ClassfileAnnotation
}
