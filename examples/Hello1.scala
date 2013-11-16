import scala.swing._
object Hello extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Hello"
    contents = new Button("Hello")
  }
}
