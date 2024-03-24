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


fun main() {
    val clubs = mutableListOf<Club>()


    // Menambahkan data klub
    clubs.add(Club("Liverpool", 19, 8, 9, 6, 3))
    clubs.add(Club("Manchester United", 20, 12, 6, 3, 1))
    clubs.add(Club("Chelsea", 6, 6, 5, 2, 2))
    clubs.add(Club("Manchester City", 8, 8, 8, 0, 0))
    clubs.add(Club("Arsenal", 13, 14, 2, 0, 0))


    // Menggunakan higher-order function untuk sorting
    val sortedClubs = filterAndSort(clubs, ::sortByNumberTrophyTotal)


    // Output hasil sorting
    println("Urutan klub berdasarkan jumlah total trofi:")
    for (club in sortedClubs) {
        println(club.name)
    }


    // Menggunakan higher-order function untuk filtering
    val filteredClubs = filterAndSort(clubs, ::filterByEuropeanTrophy)


    // Output hasil filtering
    println("Klub yang belum pernah memenangkan UCL dan UEL:")
    for (club in filteredClubs) {
        println(club.name)
    }


    // Memanggil extension function recap
    println("Rekap Perolehan Trofi:")
    clubs.forEach { println(it.trophySummary()) }
}


// High order function filter and sort
fun filterAndSort(clubs: List<Club>, options: (List<Club>) -> List<Club>): List<Club> {
    return options(clubs)
}


// Fungsi sorting
fun sortByNumberTrophyTotal(clubs: List<Club>): List<Club> {
    return clubs.sortedByDescending { it.totalTrophy }
}


// Fungsi filter
fun filterByEuropeanTrophy(clubs: List<Club>): List<Club> {
    return clubs.filter { it.championsLeague == 0 && it.uefaEuropaLeague == 0 }
}


// Extension function recap
fun Club.trophySummary(): String {
    return buildString {
        append("$name berhasil meraih ")
        append("$epl trofi Liga Primer Inggris, ")
        append("$fa trofi FA, ")
        append("$efl trofi EFL, ")
        append("$championsLeague trofi Liga Champions, ")
        append("dan $uefaEuropaLeague trofi Liga Eropa UEFA.")
    }
}

