package conversor.model

import conversor.model.KilometersToMilesConversion
import conversor.model.MilesToKilometersConversion
import org.junit.Test
import org.junit.Assert.assertEquals

class TestConversion {
	@Test fun testGetName() {
		assertEquals("miles -> kms", MilesToKilometersConversion().getName())
		assertEquals("kms -> miles", KilometersToMilesConversion().getName())
	}
	
	@Test fun testConvert() {
		assertEquals(1.60934, MilesToKilometersConversion().convert(1.0), 0.0001)
		assertEquals(1/1.60934, KilometersToMilesConversion().convert(1.0), 0.0001)
	}
}
