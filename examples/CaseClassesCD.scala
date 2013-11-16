class C {
  override def equals(that: Any) = super.equals(that)
  override def hashCode = super.hashCode
  override def toString = super.toString
}
case class D(a:Int, b:String, c:Long) extends C
