class RandomNumberIterator
extends scala.collection.Iterator[Int] {
  def hasNext = true
  def next = scala.util.Random.nextInt(10)
}
object Migration {
  val a = new RandomNumberIterator
  a.collect { case x => x.toString }
}
