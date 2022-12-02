
import scala.io.Source

import java.io.FileNotFoundException
import java.io.IOException
import scala.io.Source

object TryCatchFinally_v4 extends App {

  try {
    val sourcePath = Source.fromFile("src/main/resources/dividendStockss.csv")

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
  }

  println("----------------End of code reached")
}
