
object PartialFunctions_v1 {

  def main(args: Array[String]): Unit = {

    val divide64By = (x: Int) => 64 / x

    println(divide64By(8))

    println(divide64By(0))
  }
}
