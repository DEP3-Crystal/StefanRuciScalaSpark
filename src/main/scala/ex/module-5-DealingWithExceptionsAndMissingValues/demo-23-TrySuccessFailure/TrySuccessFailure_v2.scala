
import scala.util.{Failure, Success, Try}
import scala.io.{BufferedSource, Source}

object TrySuccessFailure_v2 extends App {

  def getLinesFromFile(filename:String): Try[BufferedSource] = {
      Try(Source.fromFile(filename))
  }

  val trySourcePath:Try[BufferedSource] =
    getLinesFromFile("src/main/resources/dividendStockss.csv")

  trySourcePath match {
    case Success(sourcePath) => sourcePath.getLines.toList.foreach(println)

    case Failure(exception) => println(exception.getMessage)
  }
}
