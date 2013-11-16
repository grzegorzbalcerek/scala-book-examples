def longerString[A, B](a: A, b: B):Any = {
  if (a.toString.length >= b.toString.length) a else b
}

