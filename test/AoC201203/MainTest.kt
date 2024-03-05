package AoC201203

import org.junit.jupiter.api.Test
import java.io.File
import java.math.BigInteger

class MainTest {

    @Test
    fun calculatePath() {
        val m = Main()
        val data: List<String> = File("test/AoC201203/sample.txt").readLines()
        val vectors = listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
        val exp1 = 7
        val exp2 = 336
        val err = 3
        val act11 = m.myPart1Before(data)
        val act12 = m.myPart1After(data, 3 to 1)
        val act21 = m.myPart2Before(data, 1, 1) *
                m.myPart2Before(data, 3, 1) *
                m.myPart2Before(data, 5, 1) *
                m.myPart2Before(data, 7, 1) *
                m.myPart2Before(data, 1, 2)
        val act22 = m.myPart2After(data, vectors)
        assert(exp1 == act11)
        assert(err != act11)
        assert(exp2 == act21)
        assert(err != act21)
        assert(exp1 == act12)
        assert(err != act12)
        assert(exp2.toLong() == act22)
        assert(err.toLong() != act22)
    }

}