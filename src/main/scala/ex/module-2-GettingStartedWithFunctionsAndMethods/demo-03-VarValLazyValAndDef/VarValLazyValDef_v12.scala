
object VarValLazyValDef_v12 extends App {

  def data:Array[String] = {
    println ("Array is initialized");
    Array("MSFT", "GOOG", "TM")
  }

  println("Before accessing data")
  data.foreach(println)

  println("---------------------")
  data.foreach(println)
}

