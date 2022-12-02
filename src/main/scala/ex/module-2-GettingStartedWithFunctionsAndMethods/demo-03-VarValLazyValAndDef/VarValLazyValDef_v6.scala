
object VarValLazyValDef_v6 extends App {
  val data = {println ("Array is initialized"); Array(
    "MSFT", "GOOG", "TM"
  )}

  println("Before accessing data")
  data.foreach(println)

  println("---------------------")
  data.foreach(println)
}

