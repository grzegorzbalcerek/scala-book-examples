import scala.xml._
import transform._
object DictionaryTransformer2 {
  def main(args: Array[String]) {
    val source = XML.loadFile("dict.xml")
    doTransform(new DictionaryTransformer2("English","en",
      "French","fr"), "dict_en_fr2.html")
    doTransform(new DictionaryTransformer2("French","fr",
      "English","en"), "dict_fr_en2.html")
    def doTransform(transformer: DictionaryTransformer2, outputFile: String) {
      val result = transformer(source)
      def doctype = new dtd.DocType("xhtml",
        dtd.PublicID("-//W3C//DTD XHTML 1.0 Strict//EN",null), Seq.empty)
      XML.save(outputFile, result, "utf-8", true, doctype)
    }
  }
}
class DictionaryTransformer2(langName1: String, langSymbol1: String,
                            langName2: String, langSymbol2: String)
extends BasicTransformer {
  override def transform(n: Node) = n match {
    case dict @ <dictionary>{_*}</dictionary> =>
<xhtml>
  <head>
    <title>{langName1}-{langName2} dictionary</title>
    <style type="text/css">
      body {{ width: 80%; margin: auto }}
    </style>
  </head>
  <body>
    <h1>{langName1}-{langName2} dictionary</h1>
    <table>
      <tr>
        <td><strong>{ langName1 }</strong></td>
        <td><strong> </strong></td>
        <td><strong>{ langName2 }</strong></td>
      </tr>{
        transform((dict \ "entry").sortBy(_ \ langSymbol1 \ "word" text))
    }
    </table>
  </body>
</xhtml>
    case <entry>{_*}</entry> =>
      <tr>
        { transformEntry(n \ langSymbol1, "") }
        <td> - </td>
        { transformEntry(n \ langSymbol2, "verb") }
      </tr>
    case <word>{ content }</word> => content
    case <gender>{content}</gender> => <em> ({ content })</em>
    case _ => super.transform(n)
  }
  def transformEntry(n: NodeSeq, kind: String) =
    <td>{
      transform(n \ "word")
    }{
      transform(n \ "gender")
    }{
      if (kind != "") " [" + kind + "] "
    }</td>
}

