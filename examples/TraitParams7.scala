class Hello5Factory(paramName: String) {
  class Hello5Name extends { val name = this.paramName } with Hello5
  def create = new Hello5Name
}
