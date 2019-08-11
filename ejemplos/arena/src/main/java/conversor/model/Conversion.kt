package conversor.model

import org.uqbar.commons.model.annotations.Observable

object ConvertersList {
    val all = listOf(MilesToKilometersConversion(), KilometersToMilesConversion())
}

@Observable
abstract class Conversion {
    abstract fun convert(input: Double): Double
    abstract fun getName(): String
}

class MilesToKilometersConversion : Conversion() {
    override fun convert(input: Double) = input * 1.60934
    override fun getName() = "miles -> kms"
}

class KilometersToMilesConversion : Conversion() {
    override fun convert(input: Double) = input / 1.60934
    override fun getName() = "kms -> miles"
}
