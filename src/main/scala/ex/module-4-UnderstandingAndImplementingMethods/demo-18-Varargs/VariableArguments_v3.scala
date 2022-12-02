
object VariableArguments_v3 extends App {

  def readFinanceData():Vector[StockRecord_v1] = {
    val source = io.Source.fromFile("src/main/resources/stockMarketData.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord_v1(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5))
  }

  private val data = readFinanceData()

  def getRecords(date:String, tickers: String*):Vector[(String, String, Float)] = {
    val dateFilteredRecords = data.filter(_.date == date)

    val filteredRecords = dateFilteredRecords.filter(
      record => tickers.contains(record.ticker))

    filteredRecords.map(record => (record.date, record.ticker, record.close))
  }

  val tickers = List("TTM", "DB", "BNS")
  val records = getRecords(date = "12-06-2020", "TTM", "DB", "BNS")

  records.foreach(println)
}


