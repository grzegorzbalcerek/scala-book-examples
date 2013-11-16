def sqrtEither(x: Double):Either[String,Double] =
  if (x >= 0) Right(math.sqrt(x)) else Left("Negative argument: "+x)
