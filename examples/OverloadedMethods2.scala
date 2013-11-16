class OverloadedMethods2 {
  def add(x: Int, y: Int = 0):Int = x + y
  def add(x: String, y: String = ""):String = x + y
}
