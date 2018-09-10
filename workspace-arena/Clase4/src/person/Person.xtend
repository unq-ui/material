package person

import java.time.LocalDate
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

@Accessors
@Observable
class Person {
	
	String name
	Integer phone
	LocalDate birthday
	
	new(String name, Integer phone, LocalDate birthday) {
		this.name = name
		this.phone = phone
		this.birthday = birthday
	}
	
}
