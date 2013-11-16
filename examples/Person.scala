abstract class Person(name: String){ override def toString = name }
class Man(name: String) extends Person(name)
class Woman(name: String) extends Person(name)
class Child(name: String) extends Person(name)
