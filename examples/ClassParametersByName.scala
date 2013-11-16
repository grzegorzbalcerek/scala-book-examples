class ClassParametersByName(action: => Unit) {
  def do1 = action
  def do2 = { action; action }
  def do3 = { action; action; action }
  def do4 = { action; action; action; action }
}
