
object EitherRightLeft_v2 extends App {

  def convertToFloat(someString: String): Either[Float, Float] = {
    try {
      Right(someString.toFloat)
    } catch {
      case e:NumberFormatException =>
        Left(-1)
    }
  }

  val googStockPrices = List("1367.36", "asdf", "1360.66", "1394.20",
    "1393.33", "1404.31", "1419.82", "1429.73")

  println(googStockPrices.map(convertToFloat))
}

