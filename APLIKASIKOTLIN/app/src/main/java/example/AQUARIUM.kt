package example.myapp

class private{
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100

    fun printSize() {
        println("Width: $width cm, Length: $length cm, Height: $height cm")
    }
}

fun main() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
}
