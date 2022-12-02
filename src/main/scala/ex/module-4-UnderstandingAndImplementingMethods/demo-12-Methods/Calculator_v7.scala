
object Calculator_v7 extends App {

  def computeSum(a: Int, b: Int) {
    a + b
  }

  // When you use only curly braces with no = sign, this is a
  // procedure. The result type will definitely be Unit
  def printSum(a: Int, b: Int) {
    println("Sum of a and b is: " + (a + b))
  }

  val result = computeSum(5, 6)

  println("Result is: " + result)

  printSum(11, 12)
}
