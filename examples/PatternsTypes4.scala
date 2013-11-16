def typePattern4(value: Any):String =
  value match {
    case _ :List[Int] => "List[Int] matched"
    case _ :List[_] => "List[_] matched"
    case _ => "Not matched"
  }
