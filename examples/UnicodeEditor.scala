import scala.swing._
import event._
import java.io._
object UnicodeEditor extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Unicode Editor"
    menuBar = AppMenuBar
    contents = AppPanel
  }
}

object AppMenuBar extends MenuBar {
  contents += FileMenu
  object FileMenu extends Menu("File") {
    List(NewMenuItem, OpenMenuItem, SaveAsMenuItem, new Separator,
      ExitMenuItem) map (contents += _)
    listenTo(NewMenuItem, OpenMenuItem, SaveAsMenuItem, ExitMenuItem)
    private val fileChooser = new FileChooser
    reactions += {
      case ButtonClicked(NewMenuItem) => publish(NewDocEvent)
      case ButtonClicked(OpenMenuItem) =>
        if (fileChooser.showOpenDialog(AppPanel) == FileChooser.Result.Approve)
          publish(ReadFileEvent(fileChooser.selectedFile))
      case ButtonClicked(SaveAsMenuItem) =>
        if (fileChooser.showSaveDialog(AppPanel) == FileChooser.Result.Approve)
          publish(SaveFileEvent(fileChooser.selectedFile))
      case ButtonClicked(ExitMenuItem) => System.exit(0)
    }
    object NewMenuItem extends MenuItem("New")
    object OpenMenuItem extends MenuItem("Open...")
    object SaveAsMenuItem extends MenuItem("Save as...")
    object ExitMenuItem extends MenuItem("Exit")
  }
}

case class ReadFileEvent(file: File) extends Event

case object NewDocEvent extends Event
case class SaveFileEvent(file: File) extends Event

object AppPanel extends BoxPanel(Orientation.Horizontal) {
  contents += new ScrollPane(EditorPanel)
  contents += new BoxPanel(Orientation.Vertical) {
    contents += (new FlowPanel(FlowPanel.Alignment.Left)
                              (ButtonPanel, PageLabel))
    contents += UnicodePanel
  }
}

object EditorPanel extends TextArea(20,16) {
  import scala.io._
  listenTo(UnicodePanel, AppMenuBar.FileMenu)
  reactions += {
    case NewDocEvent => text = ""
    case ReadFileEvent(file) =>
      val source = Source.fromFile(file, "utf-8")
      try text = source.getLines.mkString("\n") finally source.close
    case SaveFileEvent(file) =>
      val writer = new OutputStreamWriter(new FileOutputStream(file), "utf-8")
      try writer.write(text) finally writer.close
    case CharSelected(c) => peer.insert(c.toString, peer.getCaret.getDot)
  }
}

case class CharSelected(c: Char) extends Event

object ButtonPanel extends FlowPanel {
  private var page = 0
  contents ++= List(Button_<<, Button_<, Button_0, Button_>, Button_>>)
  listenTo(Button_<<, Button_<, Button_0, Button_>, Button_>>)
  reactions += {
    case ButtonClicked(button) =>
      page = button match {
        case Button_<< => (page + 256 - 10) % 256
        case Button_<  => (page + 256 - 1)  % 256
        case Button_0  => 0
        case Button_>  => (page + 1)  % 256
        case Button_>> => (page + 10) % 256
      }
      publish(PageSelected(page))
  }
  object Button_0 extends Button("0")
  object Button_< extends Button("\u2039")
  object Button_> extends Button("\u203a")
  object Button_<< extends Button("\u00ab")
  object Button_>> extends Button("\u00bb")
}

case class PageSelected(num: Int) extends Event

object PageLabel extends Label("0 (0x00)") {
  listenTo(ButtonPanel)
  reactions += {
    case PageSelected(num) => text = num.toString+" "+(num formatted "(0x%02x)")
  }
}

object UnicodePanel extends Panel {
  private var page = 0
  private val cellSize = 17
  preferredSize = new Dimension(cellSize*18, cellSize*18)
  override def paintComponent(g: Graphics2D) {
    import java.awt._
    import Font._
    import geom._
    super.paintComponent(g)
    val font = new Font(g.getFont.getName, PLAIN, (cellSize*0.8).toInt)
    g.setFont(font)
    drawCells; drawChars; drawCols; drawRows
    def drawCells = for (col <- 0 to 15; row <- 0 to 15)
      g.draw(new Rectangle2D.Double((col+2)*cellSize,
       (row+1)*cellSize, cellSize, cellSize))
    def drawChars = for (col <- 0 to 15; row <- 0 to 15)
      drawString(mkChar(page, col, row).toString, col+2, row+1)
    def drawCols = for (col <- 0 to 15)
      drawString(col.toHexString, col+2, 0)
    def drawRows = for (row <- 0 to 15)
      drawString(mkChar(page,0,row).toInt formatted "%04x",0,row+1,cellSize/2)
    def drawString(str: String, col: Int, row: Int, xOffset: Int = 0) {
      val bounds = font.getStringBounds(str, g.getFontRenderContext)
      val dx = ((cellSize-bounds.getWidth)/2-bounds.getX).toInt + xOffset
      val dy = ((cellSize-bounds.getHeight)/2-bounds.getY).toInt
      g.drawString(str, col*cellSize+dx , row*cellSize+dy)
    }
  }
  def mkChar(page: Int, col: Int, row: Int) = (256*page+row*16+col).toChar
  listenTo(mouse.clicks, ButtonPanel)
  reactions += {
    case PageSelected(num) => page = num; repaint
    case PositionClicked(col,row) => publish(CharSelected(mkChar(page,col,row)))
  }
  object PositionClicked {
    def unapply(e: MouseClicked): Option[(Int,Int)] =
      if (e.point.x < 2*cellSize || e.point.x > 18*cellSize ||
          e.point.y < cellSize || e.point.y > 17*cellSize) None
      else Some(((e.point.x-2*cellSize)/cellSize,(e.point.y-cellSize)/cellSize))
  }
}
