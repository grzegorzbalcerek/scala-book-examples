def underscorePattern2(value: Any) =
  value match {
    case "abc" => "String abc matched."
    case _ => "Other value."
    case 11 => "Number 11 abc matched."
  }
