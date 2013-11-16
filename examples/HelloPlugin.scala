import scala.tools.nsc.{Global, Phase}
import scala.tools.nsc.plugins.{Plugin, PluginComponent}
class HelloPlugin(override val global: Global) extends Plugin {
  override val name = "hello"
  override val description = "displays a message"
  override val components = List(new HelloPluginComponent(global))
  class HelloPluginComponent(override val global: Global)
  extends PluginComponent {
    override val phaseName = "hello"
    override val runsAfter = List("parser")
    override def newPhase(prev: Phase) = new Phase(prev) {
      override def name = phaseName
      override def run = println("Hello from a plugin")
    }
  }
}
