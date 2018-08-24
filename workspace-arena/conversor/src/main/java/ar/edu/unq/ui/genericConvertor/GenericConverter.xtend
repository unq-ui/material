package ar.edu.unq.ui.genericConvertor

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException

@Accessors
@Observable
class GenericConverter {
	double input
	double output
	Conversion conversion
	
	def void convert() {
		if (input.naN) {
			throw new UserException("No se ingresó nada como input")
		}
		if (conversion === null) {
			throw new UserException("No se elegió conversión")
		}
		output = conversion.convert(this.input)
	}
	
	//Todas las posibles conversiones
	def getPossibleConversions() {
		Conversion.allConversions
	}
	
}