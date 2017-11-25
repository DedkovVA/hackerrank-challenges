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
      val result = solve(n, k, x)
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

    def solve(n: Int, k: Int, x: Array[Int]): Int = {
      val sorted = x.sorted

      def solveCluster(cluster: ArrayBuffer[Int]): Int = {
        val amp = cluster(cluster.length - 1) - cluster.head + 1
        val span = 2*k + 1
        val t = amp / span
        if (amp % span == 0) t else t + 1
      }

      val clusters = findClusters(k, sorted)

      clusters.map(solveCluster).sum
    }
  }
}
