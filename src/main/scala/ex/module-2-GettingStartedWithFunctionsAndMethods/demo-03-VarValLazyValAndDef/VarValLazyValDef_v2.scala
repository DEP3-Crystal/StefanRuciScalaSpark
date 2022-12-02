
object VarValLazyValDef_v2 extends App {
  var stockPrice = 14
  var volume = 100


  volume = 1000

  var finalValue = stockPrice * volume

  println(s"Final value is: $finalValue")
}

