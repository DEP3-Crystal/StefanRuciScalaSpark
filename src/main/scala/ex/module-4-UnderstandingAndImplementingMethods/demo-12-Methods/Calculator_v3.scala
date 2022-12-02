
object Calculator_v3 extends App {

  def computeSum(a: Int, b: Int): Int = {
    // This will not compile, input arguments to methods are of type val
//    a = 20
//    b = 23 //reassignment to val

    return a + b
  }

  def printSum(a: Int, b: Int): Unit = {
    println("Sum of a and b is: " + (a + b))
  }

  val result = computeSum(5, 6)

  println("Result is: " + result)

  printSum(11, 12)
}
