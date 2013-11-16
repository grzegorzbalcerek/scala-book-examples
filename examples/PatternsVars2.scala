def f2(value: Any) =
  value match {
    case x => "Value "+ x + " matched"
    case "abc" => "String abc matched"
  }
