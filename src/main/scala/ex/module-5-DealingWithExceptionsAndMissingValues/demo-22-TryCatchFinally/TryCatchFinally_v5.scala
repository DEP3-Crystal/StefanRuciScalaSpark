
import scala.io.{BufferedSource, Source}
import java.io.{FileNotFoundException, IOException}

import scala.io.Source

object TryCatchFinally_v5 extends App {

  var sourcePath:BufferedSource = _

  try {
    sourcePath = Source.fromFile("src/main/resources/dividendStocks.csv")

    println("Reading file completed")

    val lines = sourcePath.getLines.toList
    lines.foreach(println)

    println("Displaying lines completed")
  } catch {
    case ex:FileNotFoundException => {
      println("File not found")
    }

    case ex:IOException => {
      println("Input/Output Exception")
    }
  } finally {
    println("Close file if it has been opened")

    if (sourcePath != null) {
      println("Closing file")
      sourcePath.close()
    }
  }

  println("----------------End of code reached")
}
