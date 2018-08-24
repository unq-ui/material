package ar.edu.unq.ui.conversor

import org.junit.Test

import static org.junit.Assert.*

class TestSynchronizedConverter {
	
	@Test def void testConvertMilesToKilometers() {
		val converter = new SynchronizedConverter()
		converter.setMiles(1)
		assertEquals(1, converter.getMiles, 0.001)
		assertEquals(1.60934, converter.getKilometers, 0.001)
	}
	
	@Test def void testConvertKilometersToMiles() {
		val converter = new SynchronizedConverter()
		converter.setKilometers(1)
		assertEquals(0.62137, converter.getMiles, 0.001)
		assertEquals(1, converter.getKilometers, 0.001)
	}
}