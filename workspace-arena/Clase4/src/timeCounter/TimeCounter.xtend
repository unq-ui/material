package timeCounter

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import java.time.LocalDate
import java.time.Period

@Accessors
@Observable
class TimeCounter {
	
	int days
	LocalDate anotherDate
	LocalDate now
	
	new() {
		now = LocalDate.now
		anotherDate = now
		days = calcular()
	}
	
	def calcular() {
		Period.between(anotherDate, now).days
	}

}
