package greetings2 {
  package hello {
    object Hi {
      def speak = println("Hi!")
    }
    package object hello {
      def talk = println("Hello!!")
    }
  }
}
