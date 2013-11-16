def greeting4(name: String)(implicit greetWord: String, n: Int):String =
  greetWord + " " + name + ("!"*n)
