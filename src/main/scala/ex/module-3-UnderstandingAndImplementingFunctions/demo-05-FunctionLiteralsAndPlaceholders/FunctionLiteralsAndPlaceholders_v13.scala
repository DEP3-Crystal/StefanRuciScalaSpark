
object FunctionLiteralsAndPlaceholders_v13 extends App {

  val sayHello = () => println("Hello function literal!")

  val multiplyBy100 = (x: Int) => x * 100

  val addTwoNumbers = (x: Int, y: Int) => x + y

  val addThreeNumbers = (x: Int, y: Int, z:Int) => x + y + z

  sayHello.apply()
  println(multiplyBy100.apply(7))
  println(addTwoNumbers.apply(7, 10))
  println(addThreeNumbers.apply(7, 10, 3))

  println("---------------------------------------")

  println("sayHello.isInstanceOf[Function0[_]]: " +
    sayHello.isInstanceOf[Function0[_]])
  println("multiplyBy100.isInstanceOf[Function1[_,_]]: " +
    multiplyBy100.isInstanceOf[Function1[_,_]])
  println("addTwoNumbers.isInstanceOf[Function2[_,_,_]]: " +
    addTwoNumbers.isInstanceOf[Function2[_,_,_]])
  println("addThreeNumbers.isInstanceOf[Function3[_,_,_,_]]: " +
    addThreeNumbers.isInstanceOf[Function3[_,_,_,_]])
}
