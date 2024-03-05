package AoC201201

import java.io.File


class Main {

    // Min lösning del 1 FÖRE
    fun mePart1Before(list: List<Int>): Int {
        for (first in list) {
            for (second in list) {
                if (first + second == 2020)
                    return first * second
            }
        }
        return 0
    }

    /*  Lösning hittad på:
        https://todd.ginsberg.com/post/advent-of-code/2020/day1/
    */
    fun toddPart1(input: List<Int>): Int =
        input.mapIndexedNotNull { idx, a ->
            input
                .drop(idx + 1)
                .dropWhile { a + it < 2020 }
                .take(1)
                .firstOrNull { a + it == 2020 }
                ?.let { a * it }
        }.first()

    // Min lösning del 1 EFTER
    fun mePart1After(list: List<Int>): Int =
        list.mapNotNull { a -> list.firstOrNull { a + it == 2020 }?.let { a * it } }.first()


    // Min lösning del 2 FÖRE
    fun mePart2Before(list: List<Int>): Int {
        for (first in list) {
            for (second in list) {
                for (third in list) {
                    if (first + second + third == 2020)
                        return first * second * third
                }
            }
        }
        return 0
    }

    /*  Del 2, lösning hämtad från:
        https://todd.ginsberg.com/post/advent-of-code/2020/day1/ */
    fun toddPart2(input: List<Int>): Int =
        input.mapIndexedNotNull { aIdx, a ->
            input
                .drop(aIdx + 1)
                .mapIndexedNotNull { bIdx, b ->
                    input
                        .drop(bIdx + 1)
                        .dropWhile { a + b + it < 2020 }
                        .take(1)
                        .firstOrNull { a + b + it == 2020 }
                        ?.let { a * b * it }
                }.firstOrNull()
        }.first()

    // Min lösning del 2 EFTER
    fun mePart2After (list: List<Int>) : Int =
        list.mapNotNull { a -> list.
            mapNotNull { b -> list.firstOrNull { a + b + it == 2020 }?.let { a * b * it } }.
            firstOrNull() }.
            first()

}

fun main() {
    val m = Main()
    val data: List<Int> = File("src/AoC201201/input.txt").readLines().map { it.toInt() }
    val dataSorted = data.sorted()
    dataSorted.forEach { println(it) }
    println("Del 1 FÖRE: ${m.mePart1Before(data)}")
    println("Del 1 MELLAN: ${m.toddPart1(dataSorted)}")
    println("Del 1 EFTER: ${m.mePart1After(data)}")
    println("Del 2 FÖRE: ${m.mePart2Before(data)}")
    println("Del 2 MELLAN: ${m.toddPart2(dataSorted)}")
    println("Del 2 EFTER: ${m.mePart2After(data)}")
}