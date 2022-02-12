import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BitOperationsTest {

	@Test
	fun `shift`() {
		assertEquals(1, 1 shl 0)
		assertEquals(2, 1 shl 1)
		assertEquals(4, 1 shl 2)
		assertEquals(8, 1 shl 3)

		assertEquals(1, 1 shr 0)
		assertEquals(0, 1 shr 1)
		assertEquals(0, 1 shr 2)
		assertEquals(0, 1 shr 3)
	}

	@Test
	fun `logical and`() {
		assertEquals(0, 0 and 0)
		assertEquals(0, 1 and 0)
		assertEquals(1, 1 and 1)

		assertEquals(0, 0 or 0)
		assertEquals(1, 1 or 0)
		assertEquals(1, 1 or 1)

		assertEquals(1, 1 and 1)

		assertEquals(0, 2 and 0)
		assertEquals(0, 2 and 1)
		assertEquals(2, 2 and 2)

		assertEquals(1, (2 + 1) and 1)
		assertEquals(2, (2 + 1) and 2)
		assertEquals(3, (2 + 1) and 3)
		assertEquals(3, (2 + 1) and 3)
	}
}
