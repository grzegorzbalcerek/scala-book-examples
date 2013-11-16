import scala.swing._
object GuiDict extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Dictionary"
    contents = DictPanel
  }
}
object InputField extends TextField(25)
object EnFrButton extends Button("English to French")
object FrEnButton extends Button("French to English")
object OutputArea extends TextArea(1, 25)
object DictPanel extends BoxPanel(Orientation.Vertical) {
  contents += new FlowPanel(InputField)
  contents += new FlowPanel(EnFrButton, FrEnButton)
  contents += new FlowPanel(OutputArea)
}
