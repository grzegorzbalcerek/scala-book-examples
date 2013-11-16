class OpTest(label: String) {
  def *= (that: OpTest) = new OpTest("("+this+" *= " +that+")")
  def xxx(that: OpTest) = new OpTest("("+this+" xxx "+that+")")
  def |  (that: OpTest) = new OpTest("("+this+" | "  +that+")")
  def =@=(that: OpTest) = new OpTest("("+this+" =@= "+that+")")
  def +  (that: OpTest) = new OpTest("("+this+" + "  +that+")")
  def *  (that: OpTest) = new OpTest("("+this+" * "  +that+")")
  def ! = new OpTest("("+this+" ! )")
  override def toString = label
}
