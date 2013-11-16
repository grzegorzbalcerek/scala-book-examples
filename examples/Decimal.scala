class Decimal(val value:Int) extends AnyVal {
  def +(x:Decimal) = new Decimal(value+x.value)
  def -(x:Decimal) = new Decimal(value-x.value)
  def *(x:Decimal) = new Decimal(value*x.value/100)
  def toInt = value/100
  def toDouble = value.toDouble/100
  override def toString = f"${value/100}.${value.abs%100}%02d"
}
