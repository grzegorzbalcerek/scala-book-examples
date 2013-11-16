def greeting3(name: String)(implicit greetWord: String = "Welcome"):String =
  greetWord + " " + name + "!"
