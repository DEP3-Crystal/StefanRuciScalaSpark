
object TypeParameters_v1 extends App {

  def pickRandomStock(tickers: Seq[String]): String = {
    val randomNumber = util.Random.nextInt(tickers.length)
    tickers(randomNumber)
  }

  def pickRandomQuantity(quantities: Seq[Int]): Int = {
    val randomNumber = util.Random.nextInt(quantities.length)
    quantities(randomNumber)
  }

  def pickRandomValue(values: Seq[Double]): Double = {
    val randomNumber = util.Random.nextInt(values.length)
    values(randomNumber)
  }

  val stock = pickRandomStock(List("PS", "TSLA", "AAPL", "FB"))
  val quantity = pickRandomQuantity(List(10, 100, 1000, 10000, 1000000))
  val value = pickRandomValue(List(10.0, 20.0, 50.0, 80.0, 100.0))

  println(s"The pick for the day is ${quantity} shares of ${stock} " +
    s"if price is greater than ${value}")
}


