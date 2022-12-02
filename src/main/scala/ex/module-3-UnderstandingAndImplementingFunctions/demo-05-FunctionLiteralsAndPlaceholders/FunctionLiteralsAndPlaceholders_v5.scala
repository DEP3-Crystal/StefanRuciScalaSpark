
object FunctionLiteralsAndPlaceholders_v5 extends App {

  var calculateResult = (x: Int, y:Int) => {
    val sum = x + y
    val diff = x - y
    val product = x * y
    val quotient = x / y

    (sum, diff, product, quotient)
  }

  println("-------- 10 and 5")
  println(calculateResult(10, 5))

  println("-------- 40 and 8")
  println(calculateResult(40, 8))
}
