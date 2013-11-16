def alternativePatterns(value: Any):String =
  value match {
    case ("abc", _) | ("abc",_,_) => "(abc,_,_) or (abc,_)"
    case (_: Int, _:Int) | (_: Long, _:Long) => "Tuple2 of Ints or Longs"
    case _ => "Not matched"
  }
