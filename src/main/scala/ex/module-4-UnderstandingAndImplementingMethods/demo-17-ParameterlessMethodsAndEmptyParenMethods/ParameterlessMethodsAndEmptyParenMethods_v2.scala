
object ParameterlessMethodsAndEmptyParenMethods_v2 extends App {

  val financeData:Vector[StockRecord_v3] = {
    val source = io.Source.fromFile("src/main/resources/GOOG.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord_v3(cols(0), cols(1).toFloat,
      cols(2).toFloat, cols(3).toFloat,
      cols(4).toFloat, cols(5).toFloat,
      cols(6).toDouble)
  }

  private val data = financeData

  val numberOfRows:Int = data.size

  val minimumCloseValue:Double = data.map(_.close).min

  val maximumCloseValue:Double = data.map(_.close).max

  val averageCloseValue:Double = data.map(_.close).sum / data.size

  println(s"Number of rows: " + numberOfRows)
  println(s"Minimum close value: " + minimumCloseValue)
  println(s"Maximum close value: " + maximumCloseValue)
  println(s"Average close value: " + averageCloseValue)
}


