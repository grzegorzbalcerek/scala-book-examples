def regexPatterns(value: Any):String = {
  val ThreeLettersFirstX = "x(.)(.)".r
  val StringStartingWithA = "A(.*)".r
  val OptionNameAndValue = "-([a-z]+)=(.+)".r
  value match {
    case ThreeLettersFirstX(a,b) => "Letters "+a+" and "+b+" are after x"
    case StringStartingWithA(_) => "String starting with A"
    case OptionNameAndValue(n,v) => "Option "+n+" has value "+v
    case _ => "not matched"
  }
}
