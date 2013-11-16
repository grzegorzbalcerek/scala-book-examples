class TestTracePlugin1 {
  def f1 = { 4 }
  def f2 = { println("trace: in method f2"); { 4 } }
}
