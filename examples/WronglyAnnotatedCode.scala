@version(1,2)
@version(major = WronglyAnnotatedCode.m1, minor = WronglyAnnotatedCode.m2)
object WronglyAnnotatedCode {
  final val m1 = 1
  final val m2 : Int = 2
  @comment def f() {}
}
