package unquify

import org.uqbar.arena.bindings.ValueTransformer

class DurationTransformer implements ValueTransformer<Integer, String> {
	
	override getModelType() {
		Integer
	}
	
	override getViewType() {
		String
	}
	
	override modelToView(Integer valueFromModel) {
		'''«valueFromModel / 60»:«String.format("%02d", valueFromModel % 60)»'''
	}
	
	override viewToModel(String valueFromView) {
		val result = valueFromView.split(":")
		var seconds = 0
		if (result.length == 2) {
			seconds += new Integer(result.get(1))
		}
		(new Integer(result.get(0)) * 60) + seconds
	}
	
}