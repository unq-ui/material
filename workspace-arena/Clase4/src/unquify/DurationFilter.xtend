package unquify

import org.uqbar.arena.filters.TextFilter
import org.uqbar.arena.widgets.TextInputEvent

class DurationFilter implements TextFilter {
	
	override accept(TextInputEvent event) {
		event.potentialTextResult.matches("^\\d+:?\\d{0,2}?$")
		// una mejora ^\d+:?([1-5]?[0-9]?|0[0-9])$ pero con un error, se puede poner 1:6 lo que no tiene sentido
	}
	
}