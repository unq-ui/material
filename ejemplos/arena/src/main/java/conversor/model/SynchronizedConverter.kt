package conversor.model

import org.uqbar.commons.model.annotations.Observable

@Observable
class SynchronizedConverter {
	private val factor = 1.60934

	var miles = 0.0
		set (value) {
			if (field != value) {
				field = value
				kilometers = value * factor
			}
		}
	var kilometers = 0.0
		set (value) {
			if (field != value) {
				field = value
				miles = value / factor
			}
		}
}
