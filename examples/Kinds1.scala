import language.higherKinds
trait StringInstance[S[_]] {
  def mkInstance(s: String): S[String]
}
