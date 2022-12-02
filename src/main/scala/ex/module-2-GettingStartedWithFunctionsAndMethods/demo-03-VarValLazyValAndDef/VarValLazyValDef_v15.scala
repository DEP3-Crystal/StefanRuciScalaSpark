
object VarValLazyValDef_v15 extends App {

  var stockPrice = 14
  lazy val volume = {println("Assigning lazy val"); 100}

  println("Calculating final value")
  var finalValue = stockPrice * volume

  println(s"Final value is: $finalValue")
}

