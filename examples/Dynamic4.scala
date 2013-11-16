import language.implicitConversions
object DynamicImplicit {
  implicit class Seven(obj: Any) {
    def seven = 7
  }
}
