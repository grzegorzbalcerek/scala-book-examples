def longerString[A, B >: A](a: A, b: B):B = {
  if (a.toString.length >= b.toString.length) a else b
}
