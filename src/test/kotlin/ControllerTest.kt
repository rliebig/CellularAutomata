import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

//Do:
class TestController {

    @Test
    fun `Test the control number generation`() {
        val controller = Controller()
        controller.calculateControlNumber(0)

        val testList = mutableListOf<Int>(0,0,0,0,0,0,0,0)

        for (i in 0 until testList.size) {
            assertEquals(controller.controlNumberList[i], testList[i])
        }

        assertEquals(controller.controlNumberList.size, 8)
    }

    @Test
    fun `the controlNumber one`() {
        val controller = Controller()
        controller.calculateControlNumber(1)
        val testList = mutableListOf<Int>(0,0,0,0,0,0,0,1)
        println("---BEGIN Test the controlNumber one ---")
        println("Expected: $testList")
        println("""Actual : ${controller.controlNumberList}""")
        println("---END Test the controlNumber one ---")

        for (i in 0 until testList.size) {
            assertEquals(controller.controlNumberList[i], testList[i])
        }

        assertEquals(controller.controlNumberList.size, 8)
    }

    @Test
    fun `the controlNumber 2`() {
        val controller = Controller()
        controller.calculateControlNumber(2)
        val testList = mutableListOf<Int>(0,0,0,0,0,0,1,0)
        println("---BEGIN Test the controlNumber 2 ---")
        println("Expected: $testList")
        println("""Actual : ${controller.controlNumberList}""")
        println("---END Test the controlNumber 2 ---")

        for (i in 0 until testList.size) {
            assertEquals(controller.controlNumberList[i], testList[i])
        }

        assertEquals(controller.controlNumberList.size, 8)
    }

    @Test
    fun `controlNumber 3`() {
        val controller = Controller()
        controller.calculateControlNumber(3)
        val testList = mutableListOf<Int>(0,0,0,0,0,0,1,1)
        println("---BEGIN Test the controlNumber 3 ---")
        println("Expected: $testList")
        println("""Actual : ${controller.controlNumberList}""")
        println("---END Test the controlNumber 3 ---")

        for (i in 0 until testList.size) {
            assertEquals(controller.controlNumberList[i], testList[i])
        }

        assertEquals(controller.controlNumberList.size, 8)
    }

    @Test
    fun `controlNumber 4`() {
        val controller = Controller()
        controller.calculateControlNumber(4)
        val testList = mutableListOf<Int>(0,0,0,0,0,1,0,0)
        println("---BEGIN Test the controlNumber 4 ---")
        println("Expected: $testList")
        println("""Actual : ${controller.controlNumberList}""")
        println("---END Test the controlNumber 4 ---")

        for (i in 0 until testList.size) {
            assertEquals(controller.controlNumberList[i], testList[i])
        }

        assertEquals(controller.controlNumberList.size, 8)
    }

    @Test
    fun `controlNumber 5`() {
        val controller = Controller()
        controller.calculateControlNumber(5)
        val testList = mutableListOf<Int>(0,0,0,0,0,1,0,1)
        println("---BEGIN Test the controlNumber 4 ---")
        println("Expected: $testList")
        println("""Actual : ${controller.controlNumberList}""")
        println("---END Test the controlNumber 4 ---")

        for (i in 0 until testList.size) {
            assertEquals(controller.controlNumberList[i], testList[i])
        }

        assertEquals(controller.controlNumberList.size, 8)
    }


}