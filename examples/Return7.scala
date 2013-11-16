def f1:Int = try 1 finally return 2
def f2:Int = try return 1 finally return 2
def f3:Int = try throw new Exception finally return 2
