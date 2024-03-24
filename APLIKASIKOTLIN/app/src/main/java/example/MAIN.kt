package example.myapp
import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

class Aquarium (var length: Int = 100, var width: Int = 20, var height: Int = 40) : Parcelable {
    var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )

    fun printSize() {
        println("Width: $width cm, Length: $length cm, Height: $height cm")
        println("Volume: $volume liters")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(length)
        parcel.writeInt(width)
        parcel.writeInt(height)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Aquarium> {
        override fun createFromParcel(parcel: Parcel): Aquarium {
            return Aquarium(parcel)
        }

        override fun newArray(size: Int): Array<Aquarium?> {
            return arrayOfNulls(size)
        }
    }
}

fun buildAquarium() {
    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    aquarium6.volume = 70
    aquarium6.printSize()

    // Creating instances of Aquarium with different parameters
    val aquarium1 = Aquarium()
    aquarium1.printSize()

    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()

    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()

    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()
}

fun main() {
    // Calling buildAquarium function to demonstrate different configurations
    buildAquarium()
}