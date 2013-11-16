class ShowUtil2[T <% Show](value: T) {
  def print2 = print(value.show)
}
