
import scala.io.Source

object TryCatchFinally_v2 extends App {

  val sourcePath = Source.fromFile("src/main/resources/dividendStockss.csv")

  println("Reading file completed")

  val lines = sourcePath.getLines.toList
  lines.foreach(println)

  println("Displaying lines completed")
}
