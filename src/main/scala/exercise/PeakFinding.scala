package exercise

/**
 * Created by NKumar on 1/31/2017.
 */
object PeakFinding extends App {

  val a = Array(1, 5, 888888, 8, 9999, 50000, 48000, 1111)

  val mid = a.length / 2
  println(peak(0, a.length))

  def peak(s: Int, e: Int): Int = {
    val mid = (s + e) / 2
    if (a(mid) < a(mid - 1)) {
      peak(s, mid - 1)
    } else if (a(mid) < a(mid + 1)) {
      peak(mid + 1, e)
    }
    else {
      a(mid)
    }
  }
}

