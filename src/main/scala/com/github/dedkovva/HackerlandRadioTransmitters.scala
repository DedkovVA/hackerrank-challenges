package com.github.dedkovva

/**
  * Created by dedkov-va on 25.11.17.
  */
object HackerlandRadioTransmitters {
  object Solution {

    def main(args: Array[String]) {
      val sc = new java.util.Scanner (System.in)
      val n = sc.nextInt()
      val k = sc.nextInt()
      val x = new Array[Int](n)
      for(x_i <- 0 until n) {
        x(x_i) = sc.nextInt()
      }
      val x2 = x.filter(_ > 0)
      val result = solve(k, x2)
      println(result)
    }

    def solve(k: Int, x: Array[Int]): Int = {
      val z = x.sorted.distinct

      var n = 0
      var t = 0
      var t1 = 0
      var m = -1

      while (t < z.length) {
        val i = t + 1
        val j = i + 1
//        println(s"i = $i, j = $j")

        if (i < z.length && z(i) == z(t1) + k ||
          j < z.length && z(j) == z(t1) + k ||
          i < z.length && j < z.length && z(i) < z(t1) + k && z(j) > z(t1) + k ||
          i < z.length && z(i) - z(t1) > k) {

          n += 1
//          println(s"i = $i, j = $j, z = $z, t1 = $t1, k = $k")
          
          if (j < z.length && z(j) == z(t1) + k) {
            m = j
          } else if (i < z.length && z(i) - z(t1) > k) {
            m = t1
          } else  {
            m = i
          }
          
          t = m + 1
//          println(s"m = $m")
          
          while (t < z.length && z(t) <= z(m) + k) {
            t += 1
          }
//          println(s"t = $t")

          t1 = t
        } else {
          t += 1
        }

//        println(s"t = $t, t1 = $t1")
//        println
      }

      if (t > t1 || z(z.length - 2) == z(m) + k) {
        n += 1
      }

      n
    }
  }
}
