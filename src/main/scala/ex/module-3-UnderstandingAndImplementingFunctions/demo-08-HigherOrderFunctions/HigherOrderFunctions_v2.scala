
object HigherOrderFunctions_v2 extends App {

  val readFinanceData = () => {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord_v1(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  val records = readFinanceData()

  val extractHighPrice = (records: Vector[StockRecord_v1]) => {
    for (record <- records) yield (record.ticker, record.high)
  }

  val extractOpenPrice = (records: Vector[StockRecord_v1]) => {
    for (record <- records) yield (record.ticker, record.open)
  }

  val extractClosePrice = (records: Vector[StockRecord_v1]) => {
    for (record <- records) yield (record.ticker, record.close)
  }

  val extractPriceDelta = (records: Vector[StockRecord_v1]) => {
    for (record <- records) yield (record.ticker, record.close - record.open)
  }

  println("Open: " + extractOpenPrice(records))
  println("Close: " + extractClosePrice(records))
  println("Delta: " + extractPriceDelta(records))

}
