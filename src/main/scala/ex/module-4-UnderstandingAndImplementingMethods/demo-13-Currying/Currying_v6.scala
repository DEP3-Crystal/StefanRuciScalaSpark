
object Currying_v6 extends App {

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

  def getPrice(date: String, ticker: String, priceType:String):Float = {
    val recordsByDate = records.filter(_.date == date)
    val recordsByTicker = recordsByDate.filter(_.ticker == ticker)

    val price = priceType match {
      case "open" => recordsByTicker(0).open
      case "close" => recordsByTicker(0).close
      case "high" => recordsByTicker(0).high
      case "low" => recordsByTicker(0).low
    }

    price
  }

  val getPriceCurried = (getPrice _).curried

//  val getPriceForDate = getPriceCurried("12-06-2020") _
//
//  println("------------------DB")
//  println("Open: " + getPriceForDate("DB")("open"))
//  println("Close: " + getPriceForDate("DB")("close"))
//  println("High: " + getPriceForDate("DB")("high"))
//  println("Low: " + getPriceForDate("DB")("low"))

//  val getPriceForDateForToyota = getPriceCurried("12-06-2020")("TM") _
//
//  println("------------------TM")
//  println("Open: " + getPriceForDateForToyota("open"))
//  println("Close: " + getPriceForDateForToyota("close"))
//  println("High: " + getPriceForDateForToyota("high"))
//  println("Low: " + getPriceForDateForToyota("low"))

}


