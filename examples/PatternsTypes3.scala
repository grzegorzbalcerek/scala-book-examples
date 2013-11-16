def typePattern3(value: Any):String =
  value match {
    case _ :Array[Array[Int]] => "Array[Array[Int]] matched"
    case _ :Array[Array[_]] => "Array[Array[_]] matched"
    case _ :Array[Int] => "Array[Int] matched"
    case _ :Array[String] => "Array[String] matched"
    case _ :Array[x] => "Array[x] matched"
    case _ :Option[_] => "Option[_] matched"
    case _ :List[_] => "List[_] matched"
    case _ => "Not matched"
  }
