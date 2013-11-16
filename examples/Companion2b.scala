object Companion2 {
  private def greet3  = println("Hello (object private)")
  def greet4(instance: Companion2) = instance.greet1
}
