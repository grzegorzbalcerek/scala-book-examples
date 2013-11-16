def guards(value: Any) = value match {
  case Person(a,_) if a.length < 4 => "Hello "+a+". You have a short name!"
  case Person(a,_) if a.length > 8 => "Hello "+a+". You have a long name!"
  case Person(a,_) => "Hello "+a+"."
}
