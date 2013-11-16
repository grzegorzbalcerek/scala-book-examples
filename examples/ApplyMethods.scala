class ApplyMethods {
  def apply():String = "apply()"
  def apply(a: Int):String = "apply(a="+a+")"
  def apply(n: Int, s: String):String = "apply(n="+n+", s="+s+")"
  def apply(str1: String, str2: String):String =
    "apply(str1="+str1+", str2="+str2+")"
  def apply(x: Int, y: Int, z: Int):String =
    "apply(x="+x+", y="+y+", z="+z+")"
  def apply(p: Symbol)(q: Symbol)(r: Symbol):String =
    "apply(p="+p+")(q="+q+")(r="+r+")"
}
