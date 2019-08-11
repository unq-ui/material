package conversor.model

import org.uqbar.commons.model.annotations.Observable

@Observable
class BasicConverter {
	private val factor = 1.60934
	var miles: Double = 0.0
	var kilometers: Double = 0.0
	
	fun convert(): Double {
		kilometers = miles * factor
		return kilometers
	}
}
