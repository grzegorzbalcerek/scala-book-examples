def caseClassPattern2(value: Any) = value match {
  case "John" Person _ => "Hello John!"
  case n Person s => "Your name is "+n+" "+s
  case r RGB (_, _) => "Red component value: "+r
}
