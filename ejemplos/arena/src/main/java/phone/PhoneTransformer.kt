package phone

import org.uqbar.arena.bindings.ValueTransformer

class PhoneTransformer : ValueTransformer<Int, String> {
	
	override fun getModelType() = Int::class.java
	override fun getViewType() = String::class.java
	
	override fun modelToView(valueFromModel: Int): String {
		return valueFromModel.toString().replace("([0-9]{4})([0-9]{4})", "$1-$2")
	}
	
	override fun viewToModel(valueFromView: String) = valueFromView.replace("-", "").toInt()
}
