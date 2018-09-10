package timeCounter

import org.uqbar.arena.bindings.ValueTransformer
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class LocalDateTransformer implements ValueTransformer<LocalDate,String> {
	
	String pattern = "dd/MM/yyyy"
	
	override getModelType() {
		LocalDate
	}
	
	override getViewType() {
		String
	}
	
	override modelToView(LocalDate valueFromModel) {
		valueFromModel.format(DateTimeFormatter.ofPattern(pattern))
	}
	
	override viewToModel(String valueFromView) {
		LocalDate.parse(valueFromView, DateTimeFormatter.ofPattern(pattern))
	}
	
}