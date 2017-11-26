package com.github.dedkovva

/**
  * Created by dedkov-va on 25.11.17.
  */
object HackerlandRadioTransmitters {
  object Solution {

    import scala.collection.mutable.ArrayBuffer

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

    def findClusters(k: Int, sorted: Array[Int]): Seq[ArrayBuffer[Int]] = {
      val uniqueSorted: Array[Int] = sorted.distinct
      val n2 = uniqueSorted.length
      val spaces = new Array[Int](n2)
      for (i <- 0 to n2 - 2) {
        spaces(i) = uniqueSorted(i + 1) - uniqueSorted(i)
      }
      spaces(n2 - 1) = 0

      val clusters: ArrayBuffer[ArrayBuffer[Int]] = ArrayBuffer.empty

      var temp = ArrayBuffer.empty[Int]
      for (i <- 0 until n2) {
        temp.append(uniqueSorted(i))

        if ((spaces(i) > k || i == (n2 - 1)) && temp.nonEmpty) {
          clusters.append(temp)
          temp = ArrayBuffer.empty[Int]
        }
      }
      clusters
    }

    def solve(k: Int, x: Array[Int]): Int = {
      val sorted = x.sorted

      def solveCluster(cluster: ArrayBuffer[Int]): Int = {
        val amp1 = cluster(cluster.length - 1) - cluster.head + 1
        val span1 = 2 * k + 1
        val t1 = amp1 / span1

        if (amp1 % span1 == 0) {
          var ideal = true
          var i = 0
          var delta = k
          var xi = cluster.head
          while (i < t1 && ideal) {
            xi = xi + delta
            i += 1
            delta = span1
            ideal = cluster.contains(xi)
          }
          if (ideal) t1 else t1 + 1
        } else if ((amp1 - 1) == t1 * (2 * k) + (t1 - 1) * k) {
          var ideal = true
          var i = 0
          var delta = k
          var xi = cluster.head
          while (i < t1 && ideal) {
            xi = xi + delta
            i += 1
            delta = 3 * k
            ideal = cluster.contains(xi) && Range(xi + k + 1, xi + 2 * k).forall(e => !cluster.contains(e))
          }
          if (ideal) t1 else t1 + 1
        } else {
          t1 + 1
        }
      }

      val clusters = findClusters(k, sorted)

      clusters.map(solveCluster).sum
    }
  }
}
