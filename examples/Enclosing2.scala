class Hello1 {
  def greet = println("Hello1")
  def talk = { greet; this.greet }
  class Hello2 {
    def greet = println("Hello2")
    def talk = { this.greet; Hello1.this.greet }
  }
}
