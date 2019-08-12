package timeCounter

import org.uqbar.arena.filters.TextFilter
import org.uqbar.arena.widgets.TextInputEvent

class LocalDateFilter : TextFilter {
	
	override fun accept(event: TextInputEvent): Boolean {
		val expected = listOf("\\d", "\\d?", "/", "\\d", "\\d?", "/", "\\d{0,4}")
		val regex = expected.reversed().fold("") { result, element -> "($element$result)?" }.toRegex()

		return event.potentialTextResult.matches(regex)
	}
	
}