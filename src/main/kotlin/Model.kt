import javafx.beans.InvalidationListener
import javafx.beans.Observable
import java.rmi.UnexpectedException

object Model {
    private var fields : MutableList<MutableList<Int>>? = null
    public var displayText = ""
    public var current_gen = 0
    var calculationProgress : Double = 0.0
    var binaryString = ""

    fun getField(generation : Int, coordinate : Int) : Int {
        if(generation < 0)
            throw IllegalArgumentException("generation may not be lower than null but is $generation")
        if(generation > Configuration.generations)
            throw IllegalArgumentException("generation may not be higher than ${Configuration.generations} but is $generation")

        if(coordinate < 0)
            throw java.lang.IllegalArgumentException("coordinate may not be lower than null but is $coordinate")
        if(coordinate > Configuration.gridLength)
            throw java.lang.IllegalArgumentException("coordinate may not be higher than ${Configuration.gridLength} but is $coordinate")

        if(fields == null) {
            throw RuntimeException("fields not initialized")
        }

        return (fields!![generation][coordinate])
    }

    fun setField(generation : Int, coordinate: Int, value : Int) {
        if(generation < 0)
            throw IllegalArgumentException("generation may not be lower than null but is $generation")
        if(generation > Configuration.generations)
            throw IllegalArgumentException("generation may not be higher than ${Configuration.generations} but is $generation")

        if(coordinate < 0)
            throw java.lang.IllegalArgumentException("coordinate may not be lower than null but is $coordinate")
        if(coordinate > Configuration.gridLength - 1)
            throw java.lang.IllegalArgumentException("coordinate must be lower than ${Configuration.gridLength} but is $coordinate")

        if(fields == null) {
            throw RuntimeException("fields not initialized")
        }

        fields!![generation][coordinate] = value
    }

    fun initialize() {
        fields = mutableListOf<MutableList<Int>>()

        for(i in 0..(Configuration.generations+1)) {
            fields!!.add(mutableListOf<Int>())
            for (k in 0..(Configuration.gridLength+1)) {
                fields!![i].add(0)
            }
        }
    }
}