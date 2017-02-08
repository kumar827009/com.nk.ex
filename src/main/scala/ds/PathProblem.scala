package ds

import scala.util.control._

/**
 * Created by NKumar on 2/9/2017.
 */
/*

Given a mxn Matrix. Fins the minimum cost path.
Only horizontal moves and vertical moves are allowed.
Cannot move if a cell has 0 value
Can move if a cell has 1 value
 */
object PathProblem extends App {

  val matrix = Array(
    Array(1, 0, 1, 0),
    Array(1, 1, 1, 1),
    Array(1, 1, 0, 1),
    Array(1, 1, 1, 1)

  )
  println("Num Paths: " + findPath(matrix)(3)(3))

  def findPath(A: Array[Array[Int]])(m: Int)(n: Int): Int = {

    val solutionMatrix = Array.ofDim[Int](4, 4)
    val Exit = new Breaks

    var flag = true
    for (col <- 1 until n + 1) {
      if (A(0)(col) == 1 && flag)
        solutionMatrix(0)(col) = 1
      else if (A(0)(col) == 0 && flag) {
        solutionMatrix(0)(col) = 0
        flag = false
      } else {
        solutionMatrix(0)(col) = 0
      }
    }
    val cols = for (col <- 0 until n + 1) yield solutionMatrix(0)(col)
    flag = true
    for (row <- 1 until n + 1) {
      if (A(row)(0) == 1 && flag)
        solutionMatrix(row)(0) = 1
      else if (A(row)(0) == 0 && flag) {
        solutionMatrix(row)(0) = 0
        flag = false
      } else {
        solutionMatrix(row)(0) = 0
      }
    }

    val rows = for (row <- 0 until m + 1) yield solutionMatrix(row)(0)

    println(cols)
    println(rows)
    for {
      row <- 1 until m + 1
      col <- 1 until n + 1
    } {

      solutionMatrix(row)(col) = solutionMatrix(row - 1)(col) + solutionMatrix(row)(col - 1)
    }
    solutionMatrix(m)(n)
  }

}
