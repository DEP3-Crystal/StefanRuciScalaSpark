
object PartialFunctions_v5 extends App {

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

  val printStockRecords: PartialFunction[String, Unit] =  {
    case ticker: String if (List("MSFT", "GOOG", "TTM", "TM",  "DB", "BNS").contains(ticker)) =>
        for (lines <- data.filter(_.ticker == ticker)) {

          println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close} ")
        }
  }

//  List("DB", "TSLA") map {printStockRecords}
//  List("DB", "TSLA") collect {printStockRecords}
}
