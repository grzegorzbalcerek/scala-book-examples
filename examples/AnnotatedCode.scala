@author(AnnotatedCode.authorName)
@version(major=1,minor=0)
object AnnotatedCode {
  final val authorName = "Grzegorz Balcerek"
  private[this] val commentText = "needs to be a var"
  @todo @fixme @comment(commentText) val num1 = 2
  val num2 = num1*2 : @comment("is this value correct?")
  def hello(@fixme("unnecessary parameter") x: Int = 3) = "hello!"
  val size: Int @fixme("change to Long") = commentText.length
}

