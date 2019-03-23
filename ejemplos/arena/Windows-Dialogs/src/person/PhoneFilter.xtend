package person

import org.uqbar.arena.filters.TextFilter
import org.uqbar.arena.widgets.TextInputEvent

class PhoneFilter implements TextFilter {
	
	override accept(TextInputEvent event) {
		event.potentialTextResult.matches("^\\d{0,4}-?\\d{0,4}") &&
		event.potentialTextResult.length <= 9 && checkDash(event.potentialTextResult)
	}
	
	def checkDash(String phone) {
		if (phone.length >= 5) return phone.substring(4,5) == "-"
		return true
	}
	
}
