def sqrtOption(x:Double): Option[Double] =
  if (x >= 0) Some(math.sqrt(x)) else None
