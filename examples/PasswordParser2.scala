import scala.util.parsing.combinator._
class PasswordParser2(userName: String) extends RegexParsers {
  def password = rep(passwordItem)
  def passwordItem : Parser[Any] = forbiddenItem | passwordChar
  def forbiddenItem : Parser[Any] =
    userName ~ failure("user name cannot be a password fragment")
  def passwordChar = "[a-zA-Z0-9]".r
  override def skipWhitespace = false
  def apply(input: String) = parseAll(password, input)
}
