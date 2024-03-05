package AoC201202

import java.io.File

class Main {

    // Min lösning del 1 före
    fun myPart1Before(list: List<String>): Int =
        list.map { s -> s.split("-", " ", ": ") }
            .filter { s -> s[0].toInt() <= s[3].count { it == s[2][0] } && s[3].count { it == s[2][0] } <= s[1].toInt() }
            .count()

    // Min lösning del 1 efter
    fun myPart1After(list: List<String>): Int =
        list.map{ s -> s.split("-", " ", ": ") }.
            filter { s -> s[3].count { it == s[2][0] } in s[0].toInt()..s[1].toInt() }
            .count()

    /*
    Lösning för de båda dagarna från
    https://github.com/Zordid/adventofcode-kotlin-2020/blob/main/src/main/kotlin/Day02_PasswordPhilosophy.kt

    class Day02 : Day(2, title = "Password Philosophy") {
        val pw = parsedInput { PasswordAndPolicy(ints[0], -ints[1], cols[1][0], cols[2]) }
        override fun part1() = pw.count { it.validPart1() }
        override fun part2() = pw.count { it.validPart2() }
    }

    data class PasswordAndPolicy(val a: Int, val b: Int, val c: Char, val pw: String) {
        fun validPart1() = pw.count { it == c } in (a..b)
        fun validPart2() = (pw[a - 1] == c) xor (pw[b - 1] == c)
    }
    */

    // Min lösning del 2 före
    fun myPart2Before(list: List<String>): Int {
        return list.map { s -> s.split("-", " ", ": ") }
            .filter { s -> (s[3][s[0].toInt() - 1] == s[2][0]) xor (s[3][s[1].toInt() - 1] == s[2][0]) }.count()
    }

    // Min lösning del 2 efter (samma lösning)
    fun myPart2After(list: List<String>): Int {
        return list.map { s -> s.split("-", " ", ": ") }
            .filter { s -> (s[3][s[0].toInt() - 1] == s[2][0]) xor (s[3][s[1].toInt() - 1] == s[2][0]) }.count()
    }
}

fun main() {
    val m = Main()
    val data: List<String> = File("src/AoC201202/input.txt").readLines()
    println("Del 1 FÖRE: ${m.myPart1Before(data)}")
    println("Del 1 EFTER: ${m.myPart1After(data)}")
    println("Del 2 FÖRE: ${m.myPart2Before(data)}")
    println("Del 2 EFTER: ${m.myPart2After(data)}")
}