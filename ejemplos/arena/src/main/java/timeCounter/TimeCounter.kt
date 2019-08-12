package timeCounter

import org.eclipse.xtend.lib.annotations.Accessors
import org.mockito.cglib.core.Local
import org.uqbar.commons.model.annotations.Observable
import java.time.LocalDate
import java.time.Period

@Accessors
@Observable
class TimeCounter {
	var now: LocalDate? = LocalDate.now()
	var anotherDate: LocalDate? = now
	var days: Int? = calc()
	
	fun calc() = Period.between(anotherDate, now).days
}
