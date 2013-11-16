abstract class AbstractSum {
  def sum(a: Int): Int
}
class Sum extends AbstractSum {
  def sum(a: Int) = if (a > 0) a + sum(a-1) else 0
}
