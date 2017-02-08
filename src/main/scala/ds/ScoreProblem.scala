package ds

/**
 * Created by NKumar on 2/8/2017.
 */
object ScoreProblem extends App {
  /* Alice's Score */
  val alice = List(1, 20, 4, 6, 10)
  /* Bob's Score */
  val bob = List(10, 2, 6, 8)

  val scores = for {i <- alice
                    j <- bob
  } yield (i, j)

  val zip = alice.zip(bob).map(t => {
    if (t._1 < t._2) (0, 1) else (1, 0)
  }).foldLeft((0, 0))((t2, t1) => (t1._1 + t2._1, t2._2 + t1._2))
  if (zip._1 > zip._2) println("Alice wins !!!!") else println("Bob wins !!!!")
  println(zip)
}
