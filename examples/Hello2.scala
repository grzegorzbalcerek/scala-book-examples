import scala.swing._
object Hello extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Hello"
    contents = HelloButton
  }
}
object HelloButton extends Button("Hello") {
  import event.ButtonClicked
  reactions += {
    case ButtonClicked(_) => println("Hello!")
  }
}
