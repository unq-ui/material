package phone

import org.uqbar.arena.filters.TextFilter
import org.uqbar.arena.widgets.TextInputEvent

class PhoneFilter : TextFilter {
	override fun accept(event: TextInputEvent): Boolean {
		return event.potentialTextResult.matches("^\\d{0,4}-?\\d{0,4}".toRegex()) &&
		event.potentialTextResult.length <= 9 && checkDash(event.potentialTextResult)
	}
	
	private fun checkDash(phone: String): Boolean {
		if (phone.length < 5) return true
		return phone.substring(4,5) == "-"
	}
}
