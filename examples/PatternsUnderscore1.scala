def underscorePattern(value: Any):String =
  value match {
    case "abc" => "String abc matched."
    case 11 => "Number 11 abc matched."
    case _ => "Other value."
  }
