object multilingualHello2 extends PartialFunction[String,String] {
  def apply(lang: String): String =
    if (lang == "en") "Hello!"
    else if (lang == "it") "Ciao!"
    else throw new IllegalArgumentException(
      "I do not know the language: "+lang)
  def isDefinedAt(lang: String): Boolean =
    if (lang == "en" || lang == "it") true else false
}
