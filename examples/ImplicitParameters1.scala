def greeting(name: String)(implicit greetWord: String):String =
  greetWord + " " + name + "!"
