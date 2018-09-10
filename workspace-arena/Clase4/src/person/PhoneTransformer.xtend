package person

import org.uqbar.arena.bindings.ValueTransformer

class PhoneTransformer implements ValueTransformer<Integer, String> {
	
	override getModelType() {
		Integer
	}
	
	override getViewType() {
		String
	}
	
	override modelToView(Integer valueFromModel) {
		if (valueFromModel === null) {
			return ""
		}
		valueFromModel.toString.replaceAll("([0-9]{4})([0-9]{4})","$1-$2")
	}
	
	override viewToModel(String valueFromView) {
		new Integer(valueFromView.replace('-',''))
	}
	
}
