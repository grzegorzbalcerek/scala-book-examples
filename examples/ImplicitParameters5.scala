def greeting5(name: String)(implicit greetWord: String, ending: String):String =
  greetWord + " " + name + ending
