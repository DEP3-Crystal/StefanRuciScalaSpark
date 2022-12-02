
object HigherOrderFunctions_v4 extends App {

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

  case class StockInformation(records: Vector[StockRecord_v1]) {

    def extractHighPrice(): Vector[(String, Float)] = {
      for (record <- records) yield (record.ticker, record.high)
    }

    def extractOpenPrice(): Vector[(String, Float)] = {
      for (record <- records) yield (record.ticker, record.open)
    }

    def extractClosePrice(): Vector[(String, Float)] = {
      for (record <- records) yield (record.ticker, record.close)
    }

    def extractPriceDelta(): Vector[(String, Float)] = {
      for (record <- records) yield (record.ticker, record.close - record.open)
    }

    def extractInfo(extractFunction: () => Vector[(String, Float)]): Vector[(String, Float)] =
      extractFunction()
  }

  val stockInformation = StockInformation(records)

  println("Open: " + stockInformation.extractInfo(stockInformation.extractOpenPrice))
  println("Close: " + stockInformation.extractInfo(stockInformation.extractClosePrice))
  println("Delta: " + stockInformation.extractInfo(stockInformation.extractPriceDelta))

}


