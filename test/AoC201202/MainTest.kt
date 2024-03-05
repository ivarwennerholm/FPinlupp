package AoC201202

import org.junit.jupiter.api.Test
import java.io.File

class MainTest {

    @Test
    fun validatePasswords() {
        val m = Main()
        val data: List<String> = File("test/AoC201202/sample.txt").readLines()
        val exp1 = 2
        val exp2 = 1
        val act11 = m.myPart1Before(data)
        val act12 = m.myPart1After(data)
        val act21 = m.myPart2Before(data)
        val act22 = m.myPart2After(data)
        val err = 3
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