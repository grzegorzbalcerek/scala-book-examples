val multilingualHello3: PartialFunction[String,String] = { 
  case "en" => "Hello!"
  case "it" => "Ciao!"
}
