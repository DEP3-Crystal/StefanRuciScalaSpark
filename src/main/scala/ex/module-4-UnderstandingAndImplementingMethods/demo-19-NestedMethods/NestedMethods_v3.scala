
object NestedMethods_v3 extends App {

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

  def printStockData(ticker:String):Unit = {

    println("Date       | Ticker | Close")
    printRecords()
//   printSummary()
//printAverage()
//    printStandardDeviation()  //not found

    def printRecords():Unit = {

      val filteredRecords = data.filter(_.ticker == ticker)
      for (row <- filteredRecords) {
        println(s"${row.date} | ${row.ticker}    | ${row.close}")
      }

      printSummary()
//      printAverage()
//      printStandardDeviation()

      def printSummary():Unit = {

        printAverage()
//        printStandardDeviation()

        def printAverage(): Unit = {
          val averageClose = filteredRecords.filter(_.ticker == ticker).
            map(_.close).sum / filteredRecords.size
          println("Average close: " + averageClose)

          printStandardDeviation()

          def printStandardDeviation(): Unit = {
            var x = 0.0

            for(record <- filteredRecords) {
              x = x + Math.pow(record.close - averageClose , 2)
            }

            val variance = x / filteredRecords.size

            println("Standard deviation close: " + Math.sqrt(variance))
          }
        }

      }
    }

  }

  printStockData("BNS")
}


