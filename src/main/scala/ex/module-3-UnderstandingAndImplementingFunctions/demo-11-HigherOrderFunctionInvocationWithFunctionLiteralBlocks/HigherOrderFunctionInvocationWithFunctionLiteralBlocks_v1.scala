
object HigherOrderFunctionInvocationWithFunctionLiteralBlocks_v1 extends App {
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

  val getStockDetails = (ticker: String,
                         extractFunction: (StockRecord_v1) => Float) => {
    val filteredRecords = records.filter(_.ticker == ticker)
    assert(filteredRecords.length == 1)

    extractFunction(filteredRecords(0))
  }

  val ttmStockDetails = getStockDetails("TTM", (record: StockRecord_v1) => record.high)
  println("---------------TTM high")
  println(ttmStockDetails)

  val googStockDetails = getStockDetails("GOOG", (record: StockRecord_v1) => record.low)
  println("---------------GOOG low")
  println(googStockDetails)

}


