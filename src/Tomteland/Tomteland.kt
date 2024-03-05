package Tomteland

import java.util.TooManyListenersException

/*
Tomtarna på Nordpolen har en strikt chefs-hierarki
Högsta chefen för allt är "Tomten"
Under "Tomten" jobbar "Glader" och "Butter"
Under "Glader" jobbar "Tröger", "Trötter"och "Blyger"
Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
Under "Trötter" jobbar "Skumtomten"
Under "Skumtomten" jobbar "Dammråttan"
Under "Räven" jobbar "Gråsuggan" och "Myran"
Under "Myran" jobbar "Bladlusen"

Er uppgift är att illustrera tomtens arbetshierarki i en lämplig datastruktur.
(Det finns flera tänkbara datastrukturer här)

Skriv sedan en funktion där man anger ett namn på tomten eller någon av hens underhuggare som
inparameter.
Funktionen listar sedan namnen på alla underlydande som en given person har
Exempel: Du anger "Trötter" och får som svar ["Skumtomten", "Dammråttan"]"

För att bli godkänd på uppgiften måste du använda rekursion.

 */

class Tomteland {

    val hierarchy: Map<String, List<String>> =
        mapOf(
            "Tomten" to listOf("Glader", "Butter"),
            "Glader" to listOf("Tröger", "Trötter", "Blyger"),
            "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
            "Trötter" to listOf("Skumtomten"),
            "Skumtomten" to listOf("Dammråttan"),
            "Räven" to listOf("Gråsuggan", "Myran"),
            "Myran" to listOf("Bladlusen")
        )


    fun getUnderlings(currentName: String): List<String> {
        val acc: MutableList<String> = mutableListOf()
        fun findNextHierarchyLevel(currentName: String) {
            if (hierarchy.containsKey(currentName)) {
                val underlings = hierarchy[currentName]!!
                acc.addAll(underlings)
                for (underling in underlings) {
                    if (hierarchy.containsKey(underling))
                        findNextHierarchyLevel(underling)
                }
            }
        }
        findNextHierarchyLevel(currentName)
        return acc
    }

}

fun main() {
    var tl = Tomteland()
    println(tl.getUnderlings("Tomten"))
}