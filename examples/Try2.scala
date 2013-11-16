def hello(n: Int) =
  try {
    greet_!("Hello", n)
  } catch {
    case e: IllegalArgumentException =>
      println("Illegal argument: " + e.getMessage)
      "Hello."
    case e: RuntimeException =>
  }
