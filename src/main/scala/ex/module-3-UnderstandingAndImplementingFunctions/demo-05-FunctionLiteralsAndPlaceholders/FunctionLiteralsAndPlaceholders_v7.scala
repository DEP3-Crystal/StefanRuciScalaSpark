
object FunctionLiteralsAndPlaceholders_v7 extends App {

  val googStockPrices = List(1367.36, 1360.66, 1394.20,
    1393.33, 1404.31, 1419.82, 1429.73)

  val googStockPricesGreaterThan1400 =
    googStockPrices.filter((price: Double) => price > 1400)

  println(googStockPricesGreaterThan1400)
}
