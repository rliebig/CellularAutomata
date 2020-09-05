import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

//Do:
class TestModel {

    @Test
    fun `Model has correct boundaries`() {
        Model.initialize()
        assertEquals(Model.getField(0,0),0)
        assertEquals(Model.getField(Configuration.generations,Configuration.gridLength - 1), 0)
    }

    @Test
    fun `Model saving works`(){
        Model.setField(5,5,1)
        assertEquals(Model.getField(5,5), 1)
    }
}