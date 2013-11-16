def binders2(value: Any):String = value match {
  case t @ (p @ Person(_,_),r @ Person(_,_)) =>
    "Tuple "+t+" contains "+p+" and "+r
  case _ => "Not matched."
}
