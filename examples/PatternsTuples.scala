def tuplePattern(value: Any):String = value match {
  case (x, y) => "Tuple2. x: "+x+" y:"+y
  case (x: Int, _, _) => "Tuple3. x: "+x
  case _ => "Not matched."
}
