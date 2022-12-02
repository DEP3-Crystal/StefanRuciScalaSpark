
object MethodEvaluationStrategies_v3 extends App {
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

  def makeMomentumBasedTradingDecision(record: => StockRecord_v1, percentDelta: Float): Unit = {
    println(s"Calculating percentage move")

    lazy val stockRecord = record;

    val percentageMove = ((stockRecord.close - stockRecord.open) / stockRecord.open) * 100;

    if (percentageMove > percentDelta) {
      println(s"Buy ${stockRecord.ticker}")
    } else if (percentageMove < -percentDelta){
      println(s"Sell ${stockRecord.ticker}")
    } else {
      println(s"No call on ${stockRecord.ticker}")
    }
  }

  def getRecord(ticker: String): StockRecord_v1 = {
    println(s"Accessing record for ${ticker}")
    val filteredRecords = records.filter(_.ticker == ticker)
    assert(filteredRecords.length == 1)

    filteredRecords(0)
  }

  println("----------------------------")
  makeMomentumBasedTradingDecision(getRecord("MSFT"), 1)

  println("----------------------------")
  makeMomentumBasedTradingDecision(getRecord("TM"), 1)
}


