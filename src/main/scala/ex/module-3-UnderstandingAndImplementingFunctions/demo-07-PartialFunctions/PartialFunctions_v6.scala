
object PartialFunctions_v6 extends App {

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

  val printTechStocks = new PartialFunction[String, Unit]  {

    def apply(ticker:String):Unit = for (lines <- data.filter(_.ticker == ticker)) {
      println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close} ")
    }

    def isDefinedAt(ticker:String): Boolean = ticker == "GOOG" || ticker =="MSFT"
  }

  val printMotorStocks = new PartialFunction[String, Unit]  {

    def apply(ticker:String):Unit = for (lines <- data.filter(_.ticker == ticker)) {
      println(s"Date: ${lines.date} Ticker: ${lines.ticker} Close: ${lines.close} ")
    }

    def isDefinedAt(ticker:String): Boolean = ticker == "TM" || ticker =="TTM"
  }

  val printTechOrMotorStocks = printTechStocks orElse printMotorStocks

  printTechOrMotorStocks("TM")
  printTechOrMotorStocks("MSFT")
}
