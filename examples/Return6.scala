def hello2:Int = {
  try {
    println("Hello!")
    return 1
  }
  finally throw new Exception("HI!")
}
