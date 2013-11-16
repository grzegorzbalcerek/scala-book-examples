import language.dynamics
object DynamicGreeting extends Dynamic {
  def applyDynamic(greeting: String)(name: String, n: Int) =
    greeting + " " + name + ("!" * n)
  def welcome(name: String) = "Welcome "+name+"."
}
