package conversor.model

import conversor.model.SynchronizedConverter
import org.junit.Test
import org.junit.Assert.assertEquals

class TestSynchronizedConverter {
	
	@Test fun testConvertMilesToKilometers() {
		val converter = SynchronizedConverter()
		converter.miles = 1.0
		assertEquals(1.0, converter.miles, 0.001)
		assertEquals(1.60934, converter.kilometers, 0.001)
	}
	
	@Test fun testConvertKilometersToMiles() {
		val converter = SynchronizedConverter()
		converter.kilometers = 1.0
		assertEquals(0.62137, converter.miles, 0.001)
		assertEquals(1.0, converter.kilometers, 0.001)
	}
}