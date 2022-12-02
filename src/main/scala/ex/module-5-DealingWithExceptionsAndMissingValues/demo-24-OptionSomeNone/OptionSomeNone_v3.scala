
object OptionSomeNone_v3  extends App {

  def convertToFloat(someString: String): Option[Float] = {
    try {
      Some(someString.toFloat)
    } catch {
      case e:NumberFormatException => None
    }
  }

  val googStockPrices = List("1367.36", "1360.66", "1394.20", "asdf",
    "1393.33", "1404.31", "1419.82", "1429.73")

  val googStockPricesFloat = googStockPrices.map(convertToFloat)

  for (optionPrice <- googStockPricesFloat) {
    optionPrice match {
      case Some(price) => println(price)
      case None => println("Skipping over None")
    }
  }
}

