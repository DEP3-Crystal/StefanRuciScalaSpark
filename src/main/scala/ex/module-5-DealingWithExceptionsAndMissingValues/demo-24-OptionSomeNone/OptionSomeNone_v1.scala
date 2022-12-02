
object OptionSomeNone_v1 extends App {

  def convertToFloat(someString: String): Any = {
    try {
      val floatVal = someString.toFloat

      floatVal
    } catch {
      case e:NumberFormatException => null
    }
  }

  val googStockPrices = List("1367.36", "1360.66", "1394.20", "asdf",
    "1393.33", "1404.31", "1419.82", "1429.73")

  println(googStockPrices.map(convertToFloat))
}

