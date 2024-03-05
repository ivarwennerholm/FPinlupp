package AoC231201

import java.io.File

/* Hitta den första och andra siffran på varje rad, slå ihop dem till ett tal,
och addera alla dessa tal. För dag ett är det endast siffror, för dag två är det
både siffror och text. */

class Main {

    // Mappningstabell för talet i del 2
    val map: Map<String, Int> = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    // Min lösning del 1 FÖRE
    fun myPart1Before(list: List<String>): Int {
        return list.map { s -> s.partition { it.isDigit() } }.map { p -> p.first }
            .map { s -> "${s.first()}${s.last()}" }.sumOf { s -> s.toInt() }
    }

    // DEL 1 ANNAN LÖSNING FRÅN:
    // https://todd.ginsberg.com/post/advent-of-code/2023/day1/
    private fun calibrationValue(row: String): Int =
        "${row.first { it.isDigit() }}${row.last { it.isDigit() }}".toInt()

    fun solvePart1(input: List<String>): Int =
        input.sumOf { calibrationValue(it) }
    // SLUT

    // Min lösning del 2 EFTER
    fun myPart1After(list: List<String>): Int {
        return list.map { s -> "${s.first() { it.isDigit() }}${s.last { it.isDigit() }}".toInt() }.sum()
    }

    // Min lösning del 2 FÖRE
    fun myPart2Before(list: List<String>): Int {
        return list.map { s -> "${findFirstNumber(s)}${findLastNumber(s)}" }.sumOf { s -> s.toInt() }
    }

    // Hjälpfunktion för del 2
    fun findFirstNumber(s: String): Int {
        for (i in s.indices) {
            if (s[i].isDigit()) {
                return s[i].toString().toInt()
            } else {
                for ((word, number) in map) {
                    if (s.substring(i).startsWith(word, ignoreCase = true))
                        return number
                }
            }
        }
        return 0
    }

    // Hjälpfunktion för del 2
    fun findLastNumber(s: String): Int {
        var lastNumber = 0
        for (i in s.indices) {
            if (s[i].isDigit()) {
                lastNumber = s[i].toString().toInt()
            } else {
                for ((word, number) in map) {
                    if (s.substring(i).startsWith(word, ignoreCase = true))
                        lastNumber = number
                }
            }
        }
        return lastNumber
    }

    // DEL 2 ANNAN LÖSNING FRÅN:
    // https://github.com/n0rthdev/aoc2023/blob/master/src/main/kotlin/Day01Part2.kt
    fun solve(lines: List<String>): String {
        return lines.sumOf { line ->
            val newline = line.
                    replace("one", "one1one").
                    replace("two", "two2two").
                    replace("three", "three3three").
                    replace("four", "four4four").
                    replace("five", "five5five").
                    replace("six", "six6six").
                    replace("seven", "seven7seven").
                    replace("eight", "eight8eight").
                    replace("nine", "nine9nine")
            "${newline.first { it.isDigit() }}${newline.last { it.isDigit() }}".toLong()
        }.toString()
    }
    // DEL 2 ANNAN LÖSNING

    // Min lösning del 2 EFTER
    fun myPart2After (list: List<String>): Int {
        return list.map { line -> line.
            replace("one", "one1one").
            replace("two", "two2two").
            replace("three", "three3three").
            replace("four", "four4four").
            replace("five", "five5five").
            replace("six", "six6six").
            replace("seven", "seven7seven").
            replace("eight", "eight8eight").
            replace("nine", "nine9nine") }.
            map { s -> "${s.first() { it.isDigit() }}${s.last { it.isDigit() }}".toInt() }.sum()
    }

}

fun main() {
    val m = Main()
    val data: List<String> = File("src/AoC231201/input.txt").readLines()
    println("Del 1 FÖRE: ${m.myPart1Before(data)}")
    println("Del 1 MELLAN: ${m.solvePart1(data)}")
    println("Del 1 EFTER: ${m.myPart1After(data)}")
    println("Del 2 FÖRE: ${m.myPart2Before(data)}")
    println("Del 2 MELLAN: ${m.myPart2Before(data)}")
    println("Del 2 EFTER: ${m.myPart2After(data)}")
}