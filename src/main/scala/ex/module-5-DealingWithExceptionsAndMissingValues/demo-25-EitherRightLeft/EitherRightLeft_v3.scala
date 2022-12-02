
object EitherRightLeft_v3 extends App {

  def convertToFloat(someString: String): Either[String, Float] = {
    try {
      Right(someString.toFloat)
    } catch {
      case e:NumberFormatException =>
        Left("Encountered an error while parsing float: " + someString)
    }
  }

  val googStockPrices = List("1367.36", "1360.66", "1394.20", "asdf",
    "1393.33", "1404.31", "1419.82", "1429.73")

  val googStockPricesFloat = googStockPrices.map(convertToFloat)

  for (optionPrice <- googStockPricesFloat) {
    optionPrice match {
      case Right(price) => println(price)
      case Left(message) => println(message)
    }
  }
}

