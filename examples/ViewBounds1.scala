trait Show { def show:String }
object Show {
  implicit class ShowDouble(x: Double) extends Show {
    def show = f"$x%.2f"
  }
  implicit class ShowSymbol(x: Symbol) extends Show {
    def show = ":" + x.name
  }
}
object ShowUtil {
  def print1[T](value: T)(implicit s: T => Show) = print(value.show)
  def print2[T <% Show](value: T) = print(value.show)
}
