
object Calculator_v2 extends App {

  def computeSum(a: Int, b: Int): Int = {
    return a + b
  }

  def printSum(a: Int, b: Int): Unit = {
    println("Sum of a and b is: " + (a + b))
  }

  val result = Calculator_v2.computeSum(5, 6)

  println("Result is: " + result)

  Calculator_v2.printSum(11, 12)
}
