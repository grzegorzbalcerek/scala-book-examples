import scala.annotation.elidable
import elidable._
object ElidableMethods extends App {
  @elidable(WARNING) def warning = println("warning method")
  @elidable(INFO) def info = println("info method")
  @elidable(CONFIG) def config = println("config method")
  @elidable(1000) def method1000 = println("method1000")
  def hello = println("hello!")
  hello
  warning
  info
  config
  method1000
}
