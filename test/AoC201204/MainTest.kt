package AoC201204

import org.junit.jupiter.api.Test
import java.io.File

class MainTest {

    @Test
    fun calculatePath() {
        val m = Main()
        val text = File("test/AoC201204/sample.txt").readText()
        val textInvalid = File("test/AoC201204/invalid.txt").readText()
        val textValid = File("test/AoC201204/valid.txt").readText()
        val data: List<String> = File("test/AoC201204/sample.txt").readLines()
        val invalid: List<String> = File("test/AoC201204/invalid.txt").readLines()
        val valid: List<String> = File("test/AoC201204/valid.txt").readLines()
        val exp1 = 2
        val expInvalid = 0
        val expValid = 4
        val err = 3
        val act11 = m.myPart1Before(data)
        val act12 = m.myPart1After(text)
        val act211 = m.myPart2Before(invalid)
        val act212 = m.myPart2Before(valid)
        val act221 = m.myPart2After(textInvalid)
        val act222 = m.myPart2After(textValid)

        assert(exp1 == act11)
        assert(err != act11)
        assert(exp1 == act12)
        assert(err != act12)
        assert(expInvalid == act211)
        assert(err != act211)
        assert(expValid == act212)
        assert(err != act212)
        assert(expInvalid == act221)
        assert(err != act221)
        assert(expValid == act222)
        assert(err != act222)
    }

}