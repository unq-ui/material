package conversor.model

import conversor.model.GenericConverter
import conversor.model.KilometersToMilesConversion
import conversor.model.MilesToKilometersConversion
import org.junit.Assert.assertEquals
import org.junit.Test
import org.uqbar.commons.model.exceptions.UserException

class TestGenericConverter {
	@Test(expected = UserException::class)
	fun testConvertFailsBecauseThereIsNoInput() {
		// No se ingresó nada como input
		GenericConverter().convert()
	}
	
	@Test (expected = UserException::class)
	fun testConvertFailsBecauseThereIsNoConversionSelected() {
		// No se elegió conversión
		val converter = GenericConverter()
		converter.input = 10.0
		converter.convert()
	}
	
	@Test fun testConvertMilesToKilometers() {
		val converter = GenericConverter()
		converter.input = 1.0
		converter.conversion = MilesToKilometersConversion()
		converter.convert()
		assertEquals(1.60934, converter.output!!, 0.0001)
	}
	
	@Test fun testConvertKilometersToMiles() {
		val converter = GenericConverter()
		converter.input = 1.0
		converter.conversion = KilometersToMilesConversion()
		converter.convert()
		assertEquals(0.62137, converter.output!!, 0.0001)
	}
}