
object VarValLazyValDef_v5 extends App {
  
  var stockPrice = 14
  val volume = 100

  // we can not reassign val. So this will be error
//  volume = 1500

  var finalValue = stockPrice * volume

  println(s"Final value is: $finalValue")
}

