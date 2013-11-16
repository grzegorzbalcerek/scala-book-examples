def makeGreeter(greeting: String) = {
  var counter = 0
  () => {
    counter = counter + 1
    greeting + " " + counter
  }
}
