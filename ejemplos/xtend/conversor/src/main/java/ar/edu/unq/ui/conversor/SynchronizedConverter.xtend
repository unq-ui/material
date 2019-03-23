package ar.edu.unq.ui.conversor

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

@Accessors
@Observable
class SynchronizedConverter {
	static double FACTOR = 1.60934
	
	double miles
	double kilometers
	
	def void setMiles(double miles) {
		this.miles = miles
		this.kilometers = miles * FACTOR 
	}
	
	def void setKilometers(double kilometers) {
		this.kilometers = kilometers
		this.miles = kilometers / FACTOR
}

}