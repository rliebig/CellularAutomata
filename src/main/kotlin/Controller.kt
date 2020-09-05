class Controller {
    var controlNumber = 77
    var controlNumberList = mutableListOf<Int>()

    fun initializeModel() {
        Model.initialize()

        Model.setField(0,Configuration.gridLength / 2,1)
        Model.current_gen = 0

        calculateControlNumber()
    }

    fun calculateControlNumber(controlNumber: Int = this.controlNumber) {
        this.controlNumber = controlNumber
        this.controlNumberList = mutableListOf<Int>()


        while (this.controlNumber > 0) {
            val r = this.controlNumber % 2
            this.controlNumber /= 2
            controlNumberList.add(0,r)
        }


        while (controlNumberList.size < 8) {
            controlNumberList.add(0,0)
        }

        Model.binaryString = ""
        controlNumberList.forEach {
            Model.binaryString += it.toString()
        }
    }

    fun updateModel() {
        val currentGen = Model.current_gen
        val nextGen = currentGen + 1
        Model.current_gen = nextGen

        for(it in 1 until Configuration.gridLength - 1) {
            val leftWhite = Model.getField(currentGen,it - 1) == 0
            val middleWhite = Model.getField(currentGen,it) == 0
            val rightWhite = Model.getField(currentGen,it + 1) == 0

            val leftBlack = !leftWhite
            val middleBlack = !middleWhite
            val rightBlack = !rightWhite

            val newValue = when {
                leftBlack && middleBlack && rightBlack -> controlNumberList[0]
                leftBlack && middleBlack && rightWhite -> controlNumberList[1]
                leftBlack && middleWhite && rightBlack -> controlNumberList[2]
                leftBlack && middleWhite && rightWhite -> controlNumberList[3]
                leftWhite && middleBlack && rightBlack -> controlNumberList[4]
                leftWhite && middleBlack && rightWhite -> controlNumberList[5]
                leftWhite && middleWhite && rightBlack -> controlNumberList[6]
                leftWhite && middleWhite && rightWhite -> controlNumberList[7]
                else -> 0
            }

            Model.setField(nextGen, it, newValue)
        }

        Model.calculationProgress = currentGen.toDouble() / Configuration.generations.toDouble()
    }
}