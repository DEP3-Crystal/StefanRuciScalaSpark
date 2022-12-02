
object VarValLazyValDef_v13 extends App {
  
  var stockPrice = 14
  lazy val volume = 100

  // We can not reassign lazy val. So this will be error
//  volume = 1000

  var finalValue = stockPrice * volume

  println(s"Final value is: $finalValue")
}

