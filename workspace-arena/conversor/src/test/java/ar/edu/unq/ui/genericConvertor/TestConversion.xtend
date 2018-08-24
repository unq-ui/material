package ar.edu.unq.ui.genericConvertor

import org.junit.Test

import static org.junit.Assert.*

class TestConversion {
	
	
	
	@Test def void testGetName() {
		
		assertEquals("miles -> kms", new MilesToKilometersConversion().getName())
		assertEquals("kms -> miles", new KilometersToMilesConversion().getName())
	}
	
	@Test def void testConvert() {
		val conversion = new MilesToKilometersConversion()
		
		assertEquals(1.60934,conversion.convert(1),0.01)
		
		 val anotherConversion = new KilometersToMilesConversion()
		
		assertEquals(1/1.60934,anotherConversion.convert(1),0.01)

	}
	
		
}