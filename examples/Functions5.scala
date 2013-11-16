def filter(f: (Int) => Boolean, list: List[Int]): List[Int] =
  (if (list.isEmpty) list
   else if(f(list.head)) list.head :: filter(f, list.tail)
        else filter(f, list.tail))
