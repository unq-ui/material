package ar.edu.unq.ui.ejemploVentanaDialogo

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

@Accessors
@Observable
class BasicConverter{
	val FACTOR = 1.60934
	double miles
	double kilometers 
	
	def convert() {
		kilometers = miles * FACTOR
}

}
