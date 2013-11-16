class Hello {
  val hello = "Hello"
  var name = "John"
  def hello2 = { println("reading hello"); hello }
  def name2 = { println("reading name"); name }
  def name2_=(n: String) { println("setting name"); name = n }
}
