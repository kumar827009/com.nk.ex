package exercise

import scala.util.Random

/**
 * Created by NKumar on 1/21/2017.
 */
/*
  This exercise generates random Numbers from Min to Max
   val rand = new Random()
   rand.nextInt((max-min)+1)+min
 */
object SubArrayProblem extends App {

  val rand = new Random()
  val n = rand.nextInt(6) + 1;
  val sample = scala.collection.immutable.IndexedSeq(1, 2, 4, 5, 6, 7)
  println(sample(rand.nextInt(5) + 1))

  val res = for (i <- 1 to sample.length) yield {
    val s = scala.collection.mutable.Set[Int]()
    for (j <- 1 to i) yield {
      var k = sample(rand.nextInt(5) + 1)
      //if (s.add(k)) k else sample(rand.nextInt(5) + 1)
      while (s.add(k)) {
        k = sample(rand.nextInt(5) + 1)
      }
      k
    }
  }
  println(res)
}
