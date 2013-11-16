def typePattern1(value: Any):String =
  value match {
    case _ :Int => "Int matched"
    case x :String => "String matched. "+x.toUpperCase
    case _ :Boolean => "Boolean matched"
    case _ => "Another type matched"
  }
