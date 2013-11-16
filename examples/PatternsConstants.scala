object abc
object ABC
def constPattern(value: Any):String =
  value match {
    case "abc" => "string abc"
    case `abc` => "object abc"
    case ABC   => "object ABC"
    case 'abc  => "symbol abc"
    case 'a'   => "Char a"
    case 123   => "Int 123"
  }
