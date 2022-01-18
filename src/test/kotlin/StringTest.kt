import org.junit.jupiter.api.assertThrows
import java.lang.NumberFormatException
import kotlin.test.Test
import kotlin.test.assertEquals

class StringTest {

    @Test
    fun toInteger() {
        assertEquals(0, "0".toIntOrNull())
        assertEquals(0, "00".toIntOrNull())
        assertEquals(1, "01".toIntOrNull())
        assertEquals(1, "1".toIntOrNull())
        assertEquals(Int.MAX_VALUE, Int.MAX_VALUE.toString().toIntOrNull())
        assertEquals(Int.MAX_VALUE, "2147483647".toIntOrNull())
        assertEquals(null, "2147483648".toIntOrNull())
        assertThrows<NumberFormatException> {
            "2147483648".toInt()
        }
        assertEquals(null, "s1".toIntOrNull())
        assertEquals(null, "".toIntOrNull())
        val number: Int = 0xF1
        assertEquals("241", number.toString())
    }

    @Test
    fun toBytes() {
        assertEquals(5, "Lucas".toByteArray(Charsets.UTF_8).size) //each character is represented as 1 byte
        assertEquals(6, "Lucão".toByteArray(Charsets.UTF_8).size) //each character is represented as 1 byte, except by ã which is represented using two bytes
        assertEquals(1, "a".toByteArray(Charsets.UTF_8).size)
        assertEquals(2, "ã".toByteArray(Charsets.UTF_8).size)
    }
}
