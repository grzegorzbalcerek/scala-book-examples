def greet_!(greeting: String, n: Int):String = {
  if (n == 0) throw new RuntimeException("No greeting")
  if (n < 0) throw new IllegalArgumentException("The number must be positive.")
  if (n > 5) throw new Exception("Number too big: "+n)
  greeting + "!" * n
}
