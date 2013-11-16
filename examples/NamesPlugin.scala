import scala.tools.nsc.{Global, Phase}
import scala.tools.nsc.plugins.{Plugin, PluginComponent}
class NamesPlugin(override val global: Global) extends Plugin {
  override val name = "names"
  override val description = "emits warnings about too short names"
  override val components = List(new NamesPluginComponent(global))
  private var minLength = 2
  override def processOptions(options: List[String], error: String => Unit) =
    if (options.length > 1) error("Too many options provided for plugin "+name)
    else if (options.length == 1)
      try minLength = options(0).toInt catch {
        case e => error("Unable to process a plugin " + name +
          " option: " + options(0) + " ("+e.getMessage+").") }
  override val optionsHelp =
    Some("  -P:names:<minlength>           Minimal length of a val, var or def")
  class NamesPluginComponent(override val global: Global)
  extends PluginComponent {
    import global._
    override val phaseName = name
    override val runsAfter = List("parser")
    override val runsBefore = List("namer")
    override def newPhase(prev: Phase) = new StdPhase(prev) {
      override def apply(unit: CompilationUnit) {
        for (tree <- unit.body) tree match {
          case ValDef(_,name,_,_) => verifyName(name, tree)
          case DefDef(_,name,_,_,_,_) => verifyName(name, tree)
          case _ => }
        def verifyName(name: Name, tree: Tree) =
          if (name.length < minLength)
            unit.warning(tree.pos, "short name: "+name+
              ". Use names of at least "+minLength+" characters.")
      }
    }
  }
}
