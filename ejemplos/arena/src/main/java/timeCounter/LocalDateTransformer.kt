package timeCounter

import org.uqbar.arena.bindings.ValueTransformer
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LocalDateTransformer : ValueTransformer<LocalDate, String> {
	private var pattern = "dd/MM/yyyy"
	
	override fun getModelType() = LocalDate::class.java
	override fun getViewType() = String::class.java
	
	override fun modelToView(valueFromModel: LocalDate): String {
		return valueFromModel.format(DateTimeFormatter.ofPattern(pattern))
	}
	
	override fun viewToModel(valueFromView: String): LocalDate {
		return LocalDate.parse(valueFromView, DateTimeFormatter.ofPattern(pattern))
	}
	
}