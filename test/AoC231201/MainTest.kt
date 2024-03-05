package AoC231201

import org.junit.jupiter.api.Test
import java.io.File

class MainTest {
    private val row1 = "two1nine"
    private val row2 = "eightwothree"
    private val row3 = "abcone2threexyz"
    private val row4 = "xtwone3four"
    private val row5 = "4nineeightseven2"
    private val row6 = "zoneight234"
    private val row7 = "7pqrstsixteen"
    private val err = 100

    @Test
    fun addFirstAndLastDigitNumbers() {
        val m = Main()
        val data: List<String> = File("test/AoC231201/samplePart1.txt").readLines()
        val exp = 142
        val act1 = m.myPart1Before(data)
        val act2= m.myPart1After(data)
        assert(exp == act1)
        assert(err != act1)
        assert(exp == act2)
        assert(err != act2)
    }

    @Test
    fun addFirstAndLastDigitNumbersAndText() {
        val m = Main()
        val data: List<String> = File("test/AoC231201/samplePart2.txt").readLines()
        val exp = 281
        val act1 = m.myPart2Before(data)
        val act2 = m.myPart2After(data)
        assert(exp == act1)
        assert(err != act1)
        assert(exp == act2)
        assert(err != act2)
    }

    @Test
    fun findFirstNumber() {
        val m = Main()
        val exp1 = 2
        val exp2 = 8
        val exp3 = 1
        val exp4 = 2
        val exp5 = 4
        val exp6 = 1
        val exp7 = 7
        val act1 = m.findFirstNumber(row1)
        val act2 = m.findFirstNumber(row2)
        val act3 = m.findFirstNumber(row3)
        val act4 = m.findFirstNumber(row4)
        val act5 = m.findFirstNumber(row5)
        val act6 = m.findFirstNumber(row6)
        val act7 = m.findFirstNumber(row7)
        assert(exp1 == act1)
        assert(exp2 == act2)
        assert(exp3 == act3)
        assert(exp4 == act4)
        assert(exp5 == act5)
        assert(exp6 == act6)
        assert(exp7 == act7)
    }

    @Test
    fun findLastNumber() {
        val m = Main()
        val exp1 = 9
        val exp2 = 3
        val exp3 = 3
        val exp4 = 4
        val exp5 = 2
        val exp6 = 4
        val exp7 = 6
        val act1 = m.findLastNumber(row1)
        val act2 = m.findLastNumber(row2)
        val act3 = m.findLastNumber(row3)
        val act4 = m.findLastNumber(row4)
        val act5 = m.findLastNumber(row5)
        val act6 = m.findLastNumber(row6)
        val act7 = m.findLastNumber(row7)
        assert(exp1 == act1)
        assert(exp2 == act2)
        assert(exp3 == act3)
        assert(exp4 == act4)
        assert(exp5 == act5)
        assert(exp6 == act6)
        assert(exp7 == act7)
    }

}