package conversor.model

import conversor.model.BasicConverter
import org.junit.Test
import org.junit.Assert.assertEquals

class TestBasicConverter {
	@Test fun testConvert() {
		val converter = BasicConverter()
		converter.miles = 1.0
		assertEquals(1.60934, converter.convert(), 0.001)
	}
}
