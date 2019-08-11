package geo.model

import geo.Geo
import geo.GeoCalculator
import org.uqbar.commons.model.annotations.Observable

@Observable
class GeoModel {
    var latFrom: Double = 0.0
    var longFrom: Double = 0.0
    var latTo: Double = 0.0
    var longTo: Double = 0.0
    var result: String = "..."

    fun getDistance() {
        val geo1 = Geo(latFrom, longFrom)
        val geo2 = Geo(latTo, longTo)
        val res = GeoCalculator.distance(geo1, geo2)
        result = "Distancia: $res Kms"
    }

    fun cleanData() {
        latFrom = 0.0
        longFrom = 0.0
        latTo = 0.0
        longTo = 0.0
        result = "..."
    }
}