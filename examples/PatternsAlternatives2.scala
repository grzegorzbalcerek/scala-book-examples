def patternAlternatives2(value: Any):String =
  value match {
    case ("abc", a) | ("abc",_,_) => "(abc,_,_) or (abc,_)"
    case x @ (_: Int, _:Int) | (_: Long, _:Long) =>
      "Tuple2 of Ints or Longs"
    case _ => "Not matched"
  }
