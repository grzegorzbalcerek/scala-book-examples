import language.dynamics
object DynamicGreeting2 extends Dynamic {
  def applyDynamicNamed(greeting: String)(arg: (String, Int)) =
    greeting + " " + arg._1 + ("!" * arg._2)
}
