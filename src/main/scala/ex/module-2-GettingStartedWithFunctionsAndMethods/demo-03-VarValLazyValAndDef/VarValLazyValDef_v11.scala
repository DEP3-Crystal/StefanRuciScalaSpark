
object VarValLazyValDef_v11 extends App {

  def stockPrice: Int = {
    println("Returning stock price")
    14
  }

  def volume: Int = {
    println("Returning volume")
    100
  }

  def finalValue: Int = stockPrice * volume
  println(s"The final value is: $finalValue")

  println("--------------------------")

  def finalValueAgain: Int = stockPrice * volume
  println(s"The final value is: $finalValueAgain")
}

