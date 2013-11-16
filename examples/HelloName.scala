class HelloName(name: String) {
  def hello = println("Hello "+name+"!")
  override def toString = "HelloName("+name+")"
}
