object multilingualHello extends Function1[String,String] {
  def apply(lang: String): String =
    if (lang == "en") "Hello!"
    else if (lang == "it") "Ciao!"
    else throw new IllegalArgumentException(
      "I do not know the language: "+lang)
}
