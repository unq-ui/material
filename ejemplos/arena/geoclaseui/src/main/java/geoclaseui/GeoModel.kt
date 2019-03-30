package geoclaseui

import geoclase.Geo
import geoclase.GeoCalculator
import org.uqbar.commons.model.annotations.Observable

@Observable
class GeoModel {
    var lat1: Double = 0.0
    var long1: Double = 0.0
    var lat2: Double = 0.0
    var long2: Double = 0.0
    var result: String = "..."

    fun getDistance() {
        val geo1 = Geo(lat1, long1)
        val geo2 = Geo(lat2, long2)
        val res = GeoCalculator.distance(geo1, geo2)
        result = "Distancia: $res Kms"
    }
}