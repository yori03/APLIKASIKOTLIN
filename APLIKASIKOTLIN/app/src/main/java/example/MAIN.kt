package example.myapp

class Aquarium(var height: Int = 0) {
    fun printSize() {
        println("Aquarium size: Height = $height")
    }
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
    myAquarium.height = 60
    myAquarium.printSize()
}

fun main() {
    buildAquarium()
}
