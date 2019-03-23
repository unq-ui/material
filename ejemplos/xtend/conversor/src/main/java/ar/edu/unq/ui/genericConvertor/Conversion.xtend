package ar.edu.unq.ui.genericConvertor

import org.uqbar.commons.model.annotations.Observable

@Observable
abstract class Conversion {
	def double convert(double input)
	def String getName()
	def static allConversions (){
		#[new MilesToKilometersConversion, new KilometersToMilesConversion]
	}
}

class MilesToKilometersConversion extends Conversion {
	override convert(double input) { return input * 1.60934 }
	override getName() { "miles -> kms" }
}

class KilometersToMilesConversion extends Conversion {
	override convert(double input) { return input / 1.60934 }
	override getName() { "kms -> miles" }
}

