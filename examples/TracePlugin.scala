import scala.tools.nsc.{Global, Phase}
import scala.tools.nsc.plugins.{Plugin, PluginComponent}
import scala.tools.nsc.transform.Transform
class TracePlugin(override val global: Global) extends Plugin {
  override val name = "trace"
  override val description = "emits warnings about too short names"
  override val components = List(new TracePluginComponent(global))
  class TracePluginComponent(override val global: Global)
  extends PluginComponent with Transform {
    import global._
    override val phaseName = name
    override val runsAfter = List("parser")
    override val runsBefore = List("namer")
    override def newTransformer(unit: CompilationUnit) = new Transformer {
      override def transform(tree: Tree): Tree =
        super.transform(tree) match {
        case DefDef(flags,name,typeParam,params,resultType,body)
          if !name.toString.startsWith("<") =>
            val newBody =
              Block(
                List(
                  Apply(
                    Ident("println"),
                    List(
                      Literal(Constant("trace: in method "+name))
                    ) // List
                  ) // Apply
                ), // List
                body
              ) // Block
            DefDef(flags,name,typeParam,params,resultType,newBody)
          case t => t
        }
    }
  }
}
