package geoapi

import geoclase.Geo
import io.javalin.NotFoundResponse

data class Place(val id: Int, val name: String, val latitude: Double, val longitude: Double)
class GeoController {
    private var lastId = 0
    private val places = mutableListOf<Place>()

    fun getAll(): List<Place> = places

    fun getPlace(id: Int): Place {
        return places.firstOrNull { it.id == id }
                ?: throw NotFoundResponse("No se encontró el lugar con id $id")
    }

    fun addPlace(geo: Geo): Place {
        val place = Place(++lastId, geo.name, geo.latitude, geo.longitude)
        places.add(place)
        return place
    }

    fun updatePlace(id: Int, newGeo: Geo): Place {
        val oldPlace = getPlace(id)
        val newPlace = Place(oldPlace.id, newGeo.name, newGeo.latitude, newGeo.longitude)
        places.remove(oldPlace)
        places.add(newPlace)
        return newPlace
    }

    fun deletePlace(id: Int) {
        places.remove(getPlace(id))
    }

}