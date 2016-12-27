/**
 * Created by NKumar on 12/19/2016.
 */
object DynamicProgrammingEx1 extends App {
  println(fibDP(10))

  def fibDP(x: Int): Int = {
    val fib = new Array[Int](x + 1)
    fib(0) = 0;
    fib(1) = 1;
    for (i <- 2 until x + 1) {
      fib(i) = fib(i - 1) + fib(i - 2);
    }
    println(fib.toList)
    return fib(x);
  }

}
