def varPattern(value: Any) =
  value match {
    case "abc" => "String abc matched"
    case x => "Value "+ x + " matched"
  }
