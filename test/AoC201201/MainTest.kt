package AoC201201

import org.junit.jupiter.api.Test
import java.io.File

class MainTest {


    @Test
    fun findAndMultiplyTargetNumbers() {
        val m = Main()
        val data: List<Int> = File("test/AoC201201/sample.txt").readLines().map { s -> s.toInt() }
        val exp1 = 514579
        val exp2 = 241861950
        val err = 42000
        val act11 = m.mePart1Before(data)
        val act12 = m.mePart1After(data)
        val act21 = m.mePart2Before(data)
        val act22 = m.mePart2After(data)
        assert(exp1 == act11)
        assert(err != act11)
        assert(exp2 == act21)
        assert(err != act21)
        assert(exp1 == act12)
        assert(err != act12)
        assert(exp2 == act22)
        assert(err != act22)

    }

}