
object TypeParameters_v2 extends App {

  def pickRandom[A](list: Seq[A]): A = {
    val randomNumber = util.Random.nextInt(list.length)
    list(randomNumber)
  }

  val stock = pickRandom(List("PS", "TSLA", "AAPL", "FB"))
  val quantity = pickRandom(List(10, 100, 1000, 10000, 1000000))
  val value = pickRandom(List(10.0, 20.0, 50.0, 80.0, 100.0))

  println(s"The pick for the day is ${quantity} shares of ${stock} " +
    s"if price is greater than ${value}")
}


