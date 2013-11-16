def ifelse(cond: Boolean, ifblock: => Unit, elseblock: => Unit) =
  if (cond) ifblock else elseblock
