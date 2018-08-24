package ar.edu.unq.ui.genericConvertor

import org.junit.Test
import org.uqbar.commons.model.exceptions.UserException
import static org.junit.Assert.*

class TestGenericConverter {
	
	@Test (expected = UserException) 
	def void testConvertFailsBecauseThereIsNoInput() {
		//No se ingresó nada como input
		val converter = new GenericConverter()
		 converter.convert()
	}
	
	@Test (expected = UserException) 
	def void testConvertFailsBecauseThereIsNoConversionSelected() {
		//No se elegió conversión
		val converter = new GenericConverter()
		converter.setInput(10)
		 converter.convert()
	}
	
	@Test def void testConvertMilesToKilometers() {
		val converter = new GenericConverter()
		converter.setInput(1)
		converter.setConversion(new MilesToKilometersConversion)
		converter.convert()
		assertEquals(1.60934, converter.getOutput, 0.001)
	}
	
	@Test def void testConvertKilometersToMiles() {
		val converter = new GenericConverter()
		converter.setInput(1)
		converter.setConversion(new KilometersToMilesConversion)
		converter.convert()
		assertEquals(0.62137, converter.getOutput, 0.001)

	}
}