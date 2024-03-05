package AoC201203

import java.io.File
import java.math.BigInteger

class Main {

    // Min lösning del 1 före
    fun myPart1Before(list: List<String>): Int {
        var x = 0
        return list.drop(1).filter { s ->
            x += 3
            if (x >= s.length)
                x -= s.length
            s[x] == '#'
        }.count()
    }

    /*
    Lösning hittad på:
    https://github.com/kotlin-hands-on/advent-of-code-2020/blob/master/src/day03/day3.kt
    */
    fun solve(field: List<String>, vector: Pair<Int, Int>): Int {
        val (dx, dy) = vector
        val width = field[0].length
        return field.indices.count { y ->
            y % dy == 0 && field[y][y * dx / dy % width] == '#'
        }
    }

    // Min lösning del 1 efter
    fun myPart1After(list: List<String>, vector: Pair<Int, Int>): Int =
        list.filterIndexed { idx, s ->
            idx % vector.second == 0 && s[(vector.first * idx / vector.second) % s.length ] == '#'
            }.count()

    // Min lösning del 2 före
    fun myPart2Before(list: List<String>, xIncr: Int, yIncr: Int): Int {
        var counter = 0
        var x = 0
        var y = 0
        while (y < list.size - 1) {
            y += yIncr
            x += xIncr
            if (x >= list[y].length)
                x -= list[y].length
            if (list[y][x] == '#')
                counter++
        }
        return counter
    }

    // Min lösning del 2 efter
    fun myPart2After(list: List<String>, vectors: List<Pair<Int, Int>>): Long =
        vectors.map { myPart1After(list, it).toLong() }.reduce { a, b -> a * b }

}

fun main() {
    val m = Main()
    val data: List<String> = File("src/AoC201203/input.txt").readLines()
    
    println("Del 1 FÖRE: ${m.myPart1Before(data)}")
    println("Del 1 MELLAN: ${m.solve(data, 3 to 1)}")
    println("Del 1 EFTER: ${m.myPart1After(data, 3 to 1)}")

    val resultPart2 : Long =
            m.myPart2Before(data, 1, 1).toLong() *
            m.myPart2Before(data, 3, 1) *
            m.myPart2Before(data, 5, 1) *
            m.myPart2Before(data, 7, 1) *
            m.myPart2Before(data, 1, 2)
    println("Del 2 FÖRE: $resultPart2")
    val vectors = listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
    println("Del 2 MELLAN: ${vectors.map { m.solve(data, it).toBigInteger() }.reduce { a, b -> a * b }}")
    println("Del 2 EFTER: ${m.myPart2After(data, vectors)}")

}