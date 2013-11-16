class Welcome1 { welcome1 =>
  def greet = println("Welcome1")
  class Welcome2 { welcome2 ⇒
    def greet = println("Welcome2")
    def talk = {
      welcome1.greet
      welcome2.greet
    }
  }
}
