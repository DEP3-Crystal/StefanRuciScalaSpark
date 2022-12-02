object PartialFunctions_v4 extends App {

  val readFinanceData = () => {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord_v1(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  val data = readFinanceData()

  val printStockRecords: PartialFunction[String, Unit] = new PartialFunction[String, Unit]  {

    val recordedTickers = List("MSFT", "GOOG", "TTM", "TM",  "DB", "BNS")

    def apply(ticker: String):Unit = {
      for (lines <- data.filter(_.ticker == ticker)) {

        println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close} ")
      }
    }

    def isDefinedAt(ticker:String):Boolean = recordedTickers.contains(ticker)
  }

  if (printStockRecords.isDefinedAt("MSFT")) printStockRecords("MSFT")
}
