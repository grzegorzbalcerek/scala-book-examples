class Greeting6(val greetWord: String, val ending: String)
implicit object HelloGreeting6 extends Greeting6("Hello","!")
def greeting6(name: String)(implicit g: Greeting6):String =
  g.greetWord + " " + name + g.ending
