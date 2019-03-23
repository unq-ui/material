package ar.edu.unq.ui.conversor

import org.junit.Test

import static org.junit.Assert.*

class TestBasicConverter {
	
	
	@Test def void testConvert() {
		val converter = new BasicConverter()
		converter.setMiles(1)
		assertEquals(1.60934, converter.convert(), 0.001)
	}
}
