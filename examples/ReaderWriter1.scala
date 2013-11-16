class ReaderWriter[+T](private var content: T) {
  def read: T = content
  def write(x: T) { content = x }
}
