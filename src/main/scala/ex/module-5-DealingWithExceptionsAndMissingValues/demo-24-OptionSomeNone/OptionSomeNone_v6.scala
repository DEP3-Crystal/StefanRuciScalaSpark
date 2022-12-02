
object OptionSomeNone_v6 extends App {

  def convertToFloat(someString: String): Option[Float] = {
    try {
      Some(someString.toFloat)
    } catch {
      case e:NumberFormatException => None
    }
  }

  val googStockPrices = List("1367.36", "1360.66", "1394.20", "asdf",
    "1393.33", "1404.31", "1419.82", "1429.73")

  val googStockPricesFloat = googStockPrices.flatMap(convertToFloat)

  println(googStockPricesFloat)

  println("Average price: " + (googStockPricesFloat.sum / googStockPricesFloat.size))
}

