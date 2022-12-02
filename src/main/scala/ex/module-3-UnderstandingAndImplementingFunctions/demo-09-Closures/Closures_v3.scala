
object Closures_v3 extends App {

  def readFinanceData():Vector[StockRecord_v3] = {
    val source = io.Source.fromFile("src/main/resources/GOOG.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord_v3(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5).toFloat,
      cols(6).toDouble)
  }

  val getDecisionMakerFunction = (records: Vector[StockRecord_v3]) => {

    val makeDecision = (percentDelta: Float) => {
      val filteredRecords = records.filter(_.date == date)
      assert(filteredRecords.length == 1)

      val record = filteredRecords.head

      val percentageMove = ((record.close - record.open) / record.open) * 100

      if (percentageMove > percentDelta) {
        println(s"Buy based on date ${record.date}, " +
          s"percentage move ${percentageMove}")
      } else if (percentageMove < -percentDelta){
        println(s"Sell based on date ${record.date}, " +
          s"percentage move ${percentageMove}")
      } else {
        println(s"No call based on date ${record.date}, " +
          s"percentage move ${percentageMove}")
      }
    }

    makeDecision
  }

  var date = "2020-05-15"
  println("-----------------------")
  val decisionMaker1 = getDecisionMakerFunction(readFinanceData())

  decisionMaker1(2)

  date = "2020-03-18"
  println("-----------------------")
  val decisionMaker2 = getDecisionMakerFunction(readFinanceData())

  decisionMaker2(2)
}


