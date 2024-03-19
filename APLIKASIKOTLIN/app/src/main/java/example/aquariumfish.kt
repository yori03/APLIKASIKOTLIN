import kotlin.math.PI

open class Aquarium(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    open val shape = "rectangle"
    open var water: Double = 0.0
        get() = volume * 0.9
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open fun printSize() {
        println(shape)
        println("Width: $width cm, Length: $length cm, Height: $height cm")
        // 1 l = 1000 cm^3
        println("Volume: $volume liters Water: $water liters (${(water / volume * 100.0).toInt()}% full)")
    }
}

class TowerTank(override var height: Int, diameter: Int) :
    Aquarium(height = height, width = diameter, length = diameter) {

    override var volume: Int
        // cylinder volume = π * r^2 * h
        get() = ((width / 2.0) * (width / 2.0) * height * PI / 1000).toInt()
        set(value) {
            height = ((value * 1000 / PI) / ((width / 2.0) * (width / 2.0))).toInt()
        }

    override var water: Double = volume * 0.8
    override val shape = "cylinder"

    override fun printSize() {
        super.printSize()
        println("Diameter: $width cm")
    }
}

fun main() {
    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()

    val myTower = TowerTank(height = 40, diameter = 25)
    myTower.printSize()
}
