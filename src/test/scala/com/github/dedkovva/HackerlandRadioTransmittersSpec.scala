package com.github.dedkovva

import org.scalatest.{FreeSpec, Matchers}

/**
  * Created by dedkov-va on 25.11.17.
  */
class HackerlandRadioTransmittersSpec extends FreeSpec with Matchers {
  import HackerlandRadioTransmitters.Solution._
  "test" in {
    solve(1, Array(1, 2, 3, 4, 5)) shouldBe 2
    solve(1, Array(1, 2, 2, 3, 4, 5)) shouldBe 2
    solve(2, Array(7, 2, 4, 6, 5, 9, 12, 11)) shouldBe 3
    solve(2, Array(7, 2, 4, 4, 6, 5, 9, 12, 11)) shouldBe 3

//    1 2 3 4 5 6 7 8 9 10
//    * *     *       *

//    solve(0, Array(1, 2, 5, 9)) shouldBe 4
    solve(1, Array(1, 2, 5, 9)) shouldBe 3
    solve(2, Array(1, 2, 5, 9)) shouldBe 3
    solve(3, Array(1, 2, 5, 9)) shouldBe 2
    solve(4, Array(1, 2, 5, 9)) shouldBe 1

    solve(2, Array(1, 1, 2, 2, 5, 9)) shouldBe 3

    //    1 2 3 4 5 6 7 8 9 10
    //    *   *   * *   *   *
//    solve(0, Array(1, 3, 5, 6, 8, 10)) shouldBe 6
    solve(1, Array(1, 3, 5, 6, 8, 10)) shouldBe 5
    solve(2, Array(1, 3, 5, 6, 8, 10)) shouldBe 2
    solve(3, Array(1, 3, 5, 6, 8, 10)) shouldBe 2
    solve(4, Array(1, 3, 5, 6, 8, 10)) shouldBe 2
    solve(5, Array(1, 3, 5, 6, 8, 10)) shouldBe 1
    solve(20, Array(1, 3, 5, 6, 8, 10)) shouldBe 1

    solve(1, Array(21, 23, 25, 26, 28, 30)) shouldBe 5

    solve(1, Array(1)) shouldBe 1
    solve(1, Array(1, 2, 3)) shouldBe 1
    solve(1, Array(100000)) shouldBe 1

    // 1 2 3 4 5 6 7
    //     * *   * *
    solve(2, Array(3, 4, 6, 7)) shouldBe 2
    solve(2, Array(3, 3, 3, 4, 4, 4, 4, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 6, 6, 6, 3, 3, 3, 4, 3, 7)) shouldBe 2

    solve(2, Array(1, 2, 4, 5, 6, 8, 10)) shouldBe 3
    solve(1, Array(1, 3, 5, 6)) shouldBe 3

    solve(3, Array(1, 2, 5)) shouldBe 1
    solve(6, Array(1, 2, 5, 8)) shouldBe 1

    solve(2, Array(3, 6, 9, 12)) shouldBe 4
    solve(2, Array(1, 2, 4)) shouldBe 1
    solve(1, Array(1, 2, 4)) shouldBe 2
    solve(2, Array(9, 5, 4, 2, 6, 15, 12)) shouldBe 4
    solve(50, Array(100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 160)) shouldBe 1

    solve(2, Array(1, 3, 5, 7, 9, 11)) shouldBe 2
    solve(2, Array(1, 3, 5, 7, 9, 11, 13, 15, 17)) shouldBe 3
    solve(2, Array(1, 3, 5, 6, 7, 9, 11, 12, 13, 15, 17, 18, 19, 21, 23)) shouldBe 5
    solve(3, Array(1, 4, 7, 10, 13, 16)) shouldBe 2
    solve(3, Array(1, 4, 7, 10, 13, 16, 19, 22, 25)) shouldBe 3
  }
}
