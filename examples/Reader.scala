class Reader[+T](private val content: T) {
  def read: T = content
}
