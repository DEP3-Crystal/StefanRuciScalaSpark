
import scala.io.{BufferedSource, Source}
import java.io.{FileNotFoundException, IOException}

import scala.io.Source

object TryCatchFinally_v9 extends App {

  def getLinesFromFile(filename:String): List[String] = {
    var sourcePath:BufferedSource = null

    try {
      sourcePath = Source.fromFile(filename)

      println("Reading file completed")

      sourcePath.getLines.toList
    } catch {
      case ex:FileNotFoundException => {
        println("File not found")
        List()
      }
      case ex:IOException => {
        println("Input/Output Exception")
        List()
      }
    } finally {
      println("Close file if it has been opened")
      if (sourcePath != null) {
        println("Closing file")
        sourcePath.close()
      }
      List("avoid", "result", "expressions", "from", "the", "finally", "block")
    }
  }

  val lines = getLinesFromFile("src/main/resources/dividendStocks.csv")

  println("------Displaying lines")
  lines.foreach(println)
}
