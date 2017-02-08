package ds

/**
 * Created by NKumar on 2/3/2017.
 */

package ds

/**
 * Created by NKumar on 2/3/2017.
 */
/*
Given a 2D array. This algorithm finds the Minimum cost of path from (0,0) to (m-1,n-1)
 */
object NumberOfPaths extends App {

  val A: Array[Array[Int]] = Array(
    Array(1, 1, 1, 1),
    Array(1, 1, 1, 1),
    Array(1, 1, 1, 1),
    Array(1, 1, 1, 1)
  )
  println("Min Cost :" + numPaths(A)(3)(3))

  def numPaths(A: Array[Array[Int]])(m: Int)(n: Int): Int = {
    val solMatrix: Array[Array[Int]] = Array.ofDim[Int](4, 4) //Array(Array(0, 0, 0, 0), Array(0, 0, 0, 0), Array(0, 0, 0, 0), Array(0, 0, 0, 0))
    /* Copy the row data to solution matrix */
    solMatrix(0)(0) = A(0)(0)

    for (col <- 1 until n + 1) {
      println(A(0)(col))
      solMatrix(0)(col) = 1
    }

    for (row <- 1 until m + 1) {
      println(A(row)(0))
      solMatrix(row)(0) = 1
    }

    for {
      row <- 1 until m + 1
      col <- 1 until n + 1
    } {

      solMatrix(row)(col) = solMatrix(row - 1)(col) + solMatrix(row)(col - 1)
    }

    for {
      i <- 0 to m
      j <- 0 to n
    } println(s"($i)($j) = ${solMatrix(i)(j)}")
    solMatrix(m)(n)
  }

}
