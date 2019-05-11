package geoapi

import geoclase.Geo
import io.javalin.Context
import io.javalin.NotFoundResponse
import org.eclipse.jetty.http.HttpStatus.*

class GeoControllerContext {
    private var lastId = 0
    private val places = mutableListOf<Place>()

    /** CRUD **/

    fun getAll(ctx: Context) {
        ctx.json(places)
    }

    fun getPlace(ctx: Context) {
        val id = ctx.pathParam("id").toInt()
        ctx.json(getPlaceById(id))
    }

    fun addPlace(ctx: Context) {
        val geo = ctx.body<Geo>()
        ctx.status(CREATED_201)
        ctx.json(addGeoPlace(geo))
    }

    fun updatePlace(ctx: Context) {
        val id = ctx.pathParam("id").toInt()
        val newGeo = ctx.body<Geo>()
        val oldPlace = getPlaceById(id)
        val newPlace = Place(oldPlace.id, newGeo.name, newGeo.latitude, newGeo.longitude)
        places.remove(oldPlace)
        places.add(newPlace)
        ctx.json(newPlace)
    }

    fun deletePlace(ctx: Context) {
        val id = ctx.pathParam("id").toInt()
        places.remove(getPlaceById(id))
        ctx.status(NO_CONTENT_204)
    }

    /** Support Functions **/

    private fun getPlaceById(id: Int): Place {
        return places.firstOrNull { it.id == id }
                ?: throw NotFoundResponse("No se encontró el lugar con id $id")
    }

    fun addGeoPlace(geo: Geo): Place {
        val place = Place(++lastId, geo.name, geo.latitude, geo.longitude)
        places.add(place)
        return place
    }
}