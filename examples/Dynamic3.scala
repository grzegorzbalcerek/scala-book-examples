import language.dynamics
class DynamicProperties[T] extends Dynamic {
  val map = collection.mutable.Map[String, T]()
  def updateDynamic(name: String)(value: T) { map += (name->value) }
  def selectDynamic(name: String) = map get name
}
