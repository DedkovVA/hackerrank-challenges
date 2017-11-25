package com.github.dedkovva

import org.scalatest.{FreeSpec, Matchers}

/**
  * Created by dedkov-va on 25.11.17.
  */
class HackerlandRadioTransmittersSpec extends FreeSpec with Matchers {
  import HackerlandRadioTransmitters.Solution._
  "test" in {
    solve(5, 1, Array(1, 2, 3, 4, 5)) shouldBe 2
    solve(6, 1, Array(1, 2, 2, 3, 4, 5)) shouldBe 2
    solve(8, 2, Array(7, 2, 4, 6, 5, 9, 12, 11)) shouldBe 3
    solve(9, 2, Array(7, 2, 4, 4, 6, 5, 9, 12, 11)) shouldBe 3

//    1 2 3 4 5 6 7 8 9 10
//    * *     *       *

    solve(4, 0, Array(1, 2, 5, 9)) shouldBe 4
    solve(4, 1, Array(1, 2, 5, 9)) shouldBe 3
    solve(4, 2, Array(1, 2, 5, 9)) shouldBe 3
    solve(4, 3, Array(1, 2, 5, 9)) shouldBe 2
    solve(4, 4, Array(1, 2, 5, 9)) shouldBe 1

    println(findClusters(1, Array(1, 2, 5, 9)))
    println(findClusters(2, Array(1, 2, 5, 9)))
    println(findClusters(3, Array(1, 2, 5, 9)))
    println(findClusters(4, Array(1, 2, 5, 9)))

    solve(6, 2, Array(1, 1, 2, 2, 5, 9)) shouldBe 3

    //    1 2 3 4 5 6 7 8 9 10
    //    *   *   * *   *   *
    solve(6, 0, Array(1, 3, 5, 6, 8, 10)) shouldBe 6
    solve(6, 1, Array(1, 3, 5, 6, 8, 10)) shouldBe 5
    solve(6, 2, Array(1, 3, 5, 6, 8, 10)) shouldBe 2
    solve(6, 3, Array(1, 3, 5, 6, 8, 10)) shouldBe 2
    solve(6, 4, Array(1, 3, 5, 6, 8, 10)) shouldBe 2
    solve(6, 5, Array(1, 3, 5, 6, 8, 10)) shouldBe 1
    solve(6, 20, Array(1, 3, 5, 6, 8, 10)) shouldBe 1

    solve(6, 1, Array(21, 23, 25, 26, 28, 30)) shouldBe 5

    solve(1, 1, Array(1)) shouldBe 1
    solve(3, 1, Array(1, 2, 3)) shouldBe 1
    solve(1, 1, Array(100000)) shouldBe 1

    // 1 2 3 4 5 6 7
    //     * *   * *
    solve(4, 2, Array(3, 4, 6, 7)) shouldBe 2
  }
}
