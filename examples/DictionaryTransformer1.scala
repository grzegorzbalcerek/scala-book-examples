import java.io._
import javax.xml.transform._
import javax.xml.transform.stream._
import scala.xml._
object DictionaryTransformer1 {
  def main(args: Array[String]) {
    val factory = TransformerFactory.newInstance()
    val source = new StreamSource("dict.xml")
    doTransform(stylesheet("English","en","French","fr"), "dict_en_fr1.html")
    doTransform(stylesheet("French","fr","English","en"), "dict_fr_en1.html")
    def doTransform(stylesheet: Seq[Node], outputFile: String) {
      val transformer = factory.newTransformer(
        new StreamSource(new StringReader(stylesheet.toString)))
      transformer.clearParameters
      val output = new java.io.StringWriter
      transformer.transform(source, new StreamResult(output))
      val outputNode = XML.loadString(output.toString)
      val pp = new PrettyPrinter(80,2)
      val prettyOutput:String = pp.formatNodes(outputNode)
      writeFile(outputFile, prettyOutput)
    }
    def writeFile(fileName:String, data:String) {
      var w:FileWriter = null
      try {
        w = new FileWriter(fileName)
        w.write(data)
      }
      finally if (w != null) w.close
    }
  }
  def stylesheet(langName1: String, langSymbol1: String,
                 langName2: String, langSymbol2: String) = 
  <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="dictionary">
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
            </tr>
            <xsl:apply-templates select="entry">
              <xsl:sort select={langSymbol1+"/word/text()"}/>
            </xsl:apply-templates>
          </table>
        </body>
      </xhtml>
    </xsl:template>
    <xsl:template match="entry">
      <xsl:variable name="entrykind">
        <xsl:value-of select="@kind"/>
      </xsl:variable>
      <tr>
        <xsl:for-each select={langSymbol1}>
          <xsl:call-template name="transformEntry">
            <xsl:with-param name="kind"></xsl:with-param>
          </xsl:call-template>
        </xsl:for-each>
        <td> - </td>
        <xsl:for-each select={langSymbol2}>
          <xsl:call-template name="transformEntry">
            <xsl:with-param name="kind">
              <xsl:value-of select="$entrykind"/>
            </xsl:with-param>
          </xsl:call-template>
        </xsl:for-each>
      </tr>
    </xsl:template>
    <xsl:template match="word">
      <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="gender">
      <em> (<xsl:apply-templates/>)</em>
    </xsl:template>
    <xsl:template name="transformEntry">
      <xsl:param name="kind"/>
      <td>
        <xsl:apply-templates select="word"/>
        <xsl:apply-templates select="gender"/>
        <xsl:if test="$kind!=''"
          > [<xsl:value-of select="$kind"/>] </xsl:if>
      </td>
    </xsl:template>
  </xsl:stylesheet>
}
