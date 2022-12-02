
object EitherRightLeft_v5 extends App {

  def convertToFloat(someString: String): Option[Float] = {
    try {
      Some(someString.toFloat)
    } catch {
      case e:NumberFormatException => None
    }
  }

  def convertToFloatWithErrorMessage(optionFloat:Option[Float]):Either[String, Float] = {
    Either.cond(optionFloat.isDefined, optionFloat.get, "Float conversion unsuccessful")
  }

  val googStockPrices = List("1367.36", "asdf", "1360.66", "1394.20",
    "1393.33", "1404.31", "1419.82", "1429.73")

  val googStockPricesFloat = googStockPrices.map(convertToFloat).
    map(convertToFloatWithErrorMessage)

  println(googStockPricesFloat)
}

