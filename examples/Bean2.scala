import scala.reflect._
class Bean2 {
  @BeanProperty var name: String = _
  @BeanProperty val hello: String = "Hello!"
  @BeanProperty var bool1: Boolean = _
  @BooleanBeanProperty var bool2: Boolean = _
}
