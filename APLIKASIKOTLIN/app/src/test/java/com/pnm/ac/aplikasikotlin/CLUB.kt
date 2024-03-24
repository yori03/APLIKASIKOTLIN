package com.pnm.ac.aplikasikotlin

// data class Club
data class Club(
    val name: String,
    val epl: Int,
    val fa: Int,
    val efl: Int,
    val championsLeague: Int,
    val uefaEuropaLeague: Int
) {
    val totalTrophy: Int
        get() = epl + fa + efl + championsLeague + uefaEuropaLeague
}

// extension function recap
fun Club.recap(): String {
    return buildString {
        append("Nama club = $name\n")
        append("Perolehan trofi =\n")
        append("1. Liga Primer Inggris = $epl\n")
        append("2. FA = ${fa}\n")
        append("3. EFL = ${efl}\n")
        append("4. Liga Champions Eropa = ${championsLeague}\n")
        append("5. Liga Eropa UEFA = ${uefaEuropaLeague}\n")
    }
}

fun main() {
    val liverpool = Club("Liverpool", 19, 8, 9, 6, 3)
    val manUnited = Club("Manchester United", 20, 12, 6, 3, 1)
    val chelsea = Club("Chelsea", 6, 6, 5, 2, 2)
    val manCity = Club("Manchester City", 8, 8, 8, 0, 0)
    val arsenal = Club("Arsenal", 13, 14, 2, 0, 0)

    val clubs = listOf(liverpool, manUnited, chelsea, manCity, arsenal)

    clubs.forEachIndexed { index, club ->
        println("Poin ${index + 1}")
        println(club.recap())
    }
}
