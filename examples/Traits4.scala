trait Welcome { def welcome = "Welcome!" }
class HiWithHelloAndWelcome extends Hi with Hello with Welcome
