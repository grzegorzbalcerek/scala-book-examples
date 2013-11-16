import scala.annotation._
class author(final val value: String) extends ClassfileAnnotation
class version(val major: Int, val minor: Int) extends ClassfileAnnotation
class fixme(comment: String = "") extends Annotation
class todo extends Annotation
class comment(comment: String) extends Annotation
