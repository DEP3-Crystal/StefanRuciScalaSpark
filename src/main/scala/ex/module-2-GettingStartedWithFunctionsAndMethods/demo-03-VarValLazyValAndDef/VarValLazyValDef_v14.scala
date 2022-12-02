
object VarValLazyValDef_v14 extends App {

  var stockPrice = 14
  val volume = {println("Assigning val"); 100}

  println("Calculating final value")

  var finalValue = stockPrice * volume

  println(s"Final value is: $finalValue")
}

