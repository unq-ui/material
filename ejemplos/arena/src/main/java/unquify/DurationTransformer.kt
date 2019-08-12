package unquify

import org.uqbar.arena.bindings.ValueTransformer

class DurationTransformer : ValueTransformer<Int, String> {
	
	override fun getModelType() = Int::class.java
	override fun getViewType() = String::class.java
	
	override fun modelToView(valueFromModel: Int) =
		"${valueFromModel / 60}}:${String.format("%02d", valueFromModel % 60)}"
	
	override fun viewToModel(valueFromView: String): Int {
		val result = valueFromView.split(":")
		var seconds = 0
		if (result.size == 2) {
			seconds += result[1].toInt()
		}
		return (result[0].toInt() * 60) + seconds
	}
}
