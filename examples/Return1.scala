def div10(a: Int, b: Int): Int = {
  var result = 0
  var j = a
  while(j < b) {
    if (j % 10 == 0) return j
    j = j + 1
  }
  return 0
}
