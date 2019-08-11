package conversor

import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException

@Observable
class GenericConverter {
	var input: Double? = null
	var output: Double? = null
	var conversion: Conversion? = null
		set(value) {
			field = value
			hasConversion = field !== null
		}
	var hasConversion: Boolean = false
	val possibleConversions = ConvertersList.all

	fun convert() {
		if (input == null) throw UserException("No se ingresó nada como input")
		if (conversion === null) throw UserException("No se elegió conversión")

		output = conversion!!.convert(input!!)
	}
}