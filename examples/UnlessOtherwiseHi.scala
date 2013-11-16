import UnlessOtherwise._
def hi2(name: String) {
  unless(name == null) {
    println("Hi " + name)
  } otherwise {
    println("Hi!")
  }
}
