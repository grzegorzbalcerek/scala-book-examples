class ShowUtil2[T : Show](value: T) {
  def print2 = print(implicitly[Show[T]].show(value))
}
