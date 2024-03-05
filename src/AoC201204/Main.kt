package AoC201204

import java.io.File
import java.util.Scanner

class Main {
    fun myPart1Before(list: List<String>): Int {
        val req: List<String> = listOf("hcl", "iyr", "eyr", "ecl", "pid", "byr", "hgt")
        val passports: MutableList<List<String>> = mutableListOf()
        var passport: MutableList<String> = mutableListOf()
        for (s in list) {
            val scan = Scanner(s)
            if (s.isEmpty()) {
                passports.add(passport)
                passport = mutableListOf()
            } else {
                while (scan.hasNext()) {
                    passport.add(scan.next().substringBefore(":"))
                }
            }
        }
        if (passport.isNotEmpty())
            passports.add(passport)
        return passports.count { s -> s.containsAll(req) }
    }

    // https://todd.ginsberg.com/post/advent-of-code/2020/day4/
    fun toddsPart1(text: String): Int {
        val passports: List<String> = text.split("\n\n")
        val expectedFields = listOf("byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:")
        return passports.count { passport -> expectedFields.all { passport.contains(it) } }
    }

    fun myPart1After(text: String): Int {
        val passports: List<String> = text.split("\n\n")
        val expectedFields = listOf("byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:")
        return passports.count { passport -> expectedFields.all { passport.contains(it) } }
    }

    fun myPart2Before(list: List<String>): Int {
        val req: List<String> = listOf("hcl", "iyr", "eyr", "ecl", "pid", "byr", "hgt")
        val passports: MutableList<Map<String, String>> = mutableListOf()
        var passport: Map<String, String> = mutableMapOf()
        for (s in list) {
            val scan = Scanner(s)
            if (s.isEmpty()) {
                passports.add(passport)
                passport = mutableMapOf()
            } else {
                while (scan.hasNext()) {
                    val item = scan.next()
                    passport += item.substringBefore(":") to item.substringAfter(":")
                }
            }
        }
        if (passport.isNotEmpty())
            passports.add(passport)

        val validPassports = passports.filter { entry -> entry.keys.containsAll(req) }.filter { entry ->
            entry["byr"]?.length == 4 &&
                    entry["byr"]?.toIntOrNull() in 1920..2002 &&
                    entry["iyr"]?.length == 4 &&
                    entry["iyr"]?.toIntOrNull() in 2010..2020 &&
                    entry["eyr"]?.length == 4 &&
                    entry["eyr"]?.toIntOrNull() in 2020..2030 &&
                    entry["hgt"]?.let { h ->
                        when {
                            h.endsWith("cm") -> h.dropLast(2).toIntOrNull() in 150..193
                            h.endsWith("in") -> h.dropLast(2).toIntOrNull() in 59..76
                            else -> false
                        }
                    } == true &&
                    entry["hcl"]?.matches(Regex("#[0-9a-f]{6}")) == true &&
                    entry["ecl"] in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth") &&
                    entry["pid"]?.matches(Regex("\\d{9}")) == true
        }
        return validPassports.size
    }


    fun myPart2After(text: String): Int {
        val passports: MutableList<Map<String, String>> = mutableListOf()
        val passportStrings: List<String> = text.trim().split("\n\n", "\r\n\r\n")
        for (s in passportStrings) {
            val passportFields = s.split(" ", "\n", "\r\n")
                .associate { val (key, value) = it.split(":"); key to value }
            passports.add(passportFields)
        }
        return passports.count { hasAllRequiredFields(it) && hasValidValues(it) }
    }

    private fun hasAllRequiredFields(map: Map<String, String>): Boolean {
        val requiredFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid" /*"cid"*/)
        return map.keys.containsAll(requiredFields)
    }

    private fun hasValidValues(map: Map<String, String>): Boolean =
        map.all { (key, value) ->
            when (key) {
                "byr" -> value.length == 4 && value.toIntOrNull() in 1920..2002
                "iyr" -> value.length == 4 && value.toIntOrNull() in 2010..2020
                "eyr" -> value.length == 4 && value.toIntOrNull() in 2020..2030
                "pid" -> value.length == 9 && value.all(Char::isDigit)
                "ecl" -> value in setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
                "hgt" -> when (value.takeLast(2)) {
                    "cm" -> value.removeSuffix("cm").toIntOrNull() in 150..193
                    "in" -> value.removeSuffix("in").toIntOrNull() in 59..76
                    else -> false
                }

                "hcl" -> value matches """#[0-9a-f]{6}""".toRegex()
                else -> true
            }
        }
}


    /*
    //https://blog.jetbrains.com/kotlin/2021/09/validating-input-advent-of-code-in-kotlin/

    val passports = File("src/day04/input.txt")
    .readText()
    .trim()
    .split("\n\n", "\r\n\r\n")

    fun fromString(s: String): Map<String, String> {
        val fieldsAndValues = s.split(" ", "\n", "\r\n")
        val map: Map<String, String> = fieldsAndValues.associate {
            val (key, value) = it.split(":")
            key to value
        }
        return map
    }
    fun hasAllRequiredFields() = map.keys.containsAll(requiredFields)

    fun hasValidValues(map: Map<String, String>): Boolean =
        map.all { (key, value) ->
            when (key) {
                "byr" -> value.length == 4 && value.toIntOrNull() in 1920..2002
                "iyr" -> value.length == 4 && value.toIntOrNull() in 2010..2020
                "eyr" -> value.length == 4 && value.toIntOrNull() in 2020..2030
                "pid" -> value.length == 9 && value.all(Char::isDigit)
                "ecl" -> value in setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
                "hgt" -> when (value.takeLast(2)) {
                    "cm" -> value.removeSuffix("cm").toIntOrNull() in 150..193
                    "in" -> value.removeSuffix("in").toIntOrNull() in 59..76
                    else -> false
                }

                "hcl" -> value matches """#[0-9a-f]{6}""".toRegex()
                else -> true
            }
        }

    val passports: List<Map<String, String>> = listOf()

    fun partTwo() {
        println(passports.count { it.hasAllRequiredFields() && it.hasValidValues() })
    }
    */


    fun main() {
        val m = Main()
        val list: List<String> = File("src/AoC201204/input.txt").readLines()
        val text = File("src/AoC201204/input.txt").readText()
        println("Del 1 FÖRE: ${m.myPart1Before(list)}")
        println("Del 1 MELLAN: ${m.toddsPart1(text)}")
        println("Del 1 EFTER: ${m.myPart1After(text)}")
        println("Del 2 FÖRE: ${m.myPart2Before(list)}")
        println("Del 2 EFTER: ${m.myPart2After(text)}")
    }