object Hello {
  object Hi {
    private[Hello] def speak = println("Hi!")
  }
  def hi = Hi.speak
}
