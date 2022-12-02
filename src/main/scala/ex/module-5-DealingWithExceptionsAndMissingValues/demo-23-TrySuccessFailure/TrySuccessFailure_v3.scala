import ex.utils.Using

import java.io.{BufferedReader, FileReader}

object TrySuccessFailure_v3 extends App {

  val lines: List[String] =
    Using.resource(new BufferedReader(new FileReader(
      "src/main/resources/dividendStocks.csv"))) {
      reader => Iterator.continually(reader.readLine()).takeWhile(_ != null).toList
    }

  lines.foreach(println)
}
