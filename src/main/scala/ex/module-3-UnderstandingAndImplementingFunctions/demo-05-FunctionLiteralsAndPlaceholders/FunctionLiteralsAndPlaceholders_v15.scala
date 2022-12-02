
object FunctionLiteralsAndPlaceholders_v15 extends App {

  val readFinanceData = () => {
    val source = io.Source.fromFile("src/main/resources/GOOG.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord_v3(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5).toFloat,
      cols(6).toDouble)
  }

  var data = readFinanceData()

  val priceDelta = (_: Double) - (_:Double)

  val getDailyDelta = (openPrice:Double, closePrice:Double,
                       delta:(Double, Double) => Double) => delta(openPrice, closePrice)

  val record = data.filter(_.date == "2020-01-03")

  print(getDailyDelta(record(0).open, record(0).close, priceDelta))
}
