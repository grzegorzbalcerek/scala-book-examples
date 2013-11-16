import scala._
object Root2 {
  def test1 {
    import xml._
    println(new Comment("no comments"))
    println(new _root_.xml.Comment("no comments"))
  }
  def test2 {
    import _root_.xml._
    println(new Comment("no comments"))
    println(new scala.xml.Comment("no comments"))
  }
}
