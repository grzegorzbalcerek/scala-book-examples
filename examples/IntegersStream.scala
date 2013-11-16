def integers(n: Int): Stream[Int] = n #:: integers(n+1)
