def caseClassSequencePattern(value: Any):String = value match {
  case Numbers(_*, a) => "Last number: "+a
}
