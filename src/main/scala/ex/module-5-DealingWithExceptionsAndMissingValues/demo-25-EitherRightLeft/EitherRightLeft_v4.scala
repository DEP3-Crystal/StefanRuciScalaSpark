
object EitherRightLeft_v4 extends App {

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

  val googStockPricesFloat =
    googStockPrices.map(convertToFloat).filter(_.isRight).map(_.getOrElse(0))

  println(googStockPricesFloat)
}

