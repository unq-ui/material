package geoapi

import geoclase.Geo
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.eclipse.jetty.http.HttpStatus.*
import com.fasterxml.jackson.databind.exc.MismatchedInputException

fun main() {
    val app = Javalin.create()
            .enableRouteOverview("/routes")
            .exception(MismatchedInputException::class.java) { e, ctx ->
                ctx.status(BAD_REQUEST_400)
                ctx.json(mapOf(
                        "status" to BAD_REQUEST_400,
                        "message" to e.message
                ))
            }
            .start(7000)

    app.get("/") { ctx -> ctx.json(mapOf("message" to "Hello World")) }

    // Instancio el controller (OJO, ESTE ES OTRO!!)
    // Le agrego data para poder probar inicialmente
    val geoController = GeoControllerContext()
    geoController.addGeoPlace(Geo(-34.706272, -58.278519, "UNQ"))
    geoController.addGeoPlace(Geo(-34.709390, -58.280507, "Bernal"))
    geoController.addGeoPlace(Geo(-34.603595, -58.381717, "Obelisco"))

    // CRUD de Lugares
    // Sintaxis alternativa, mucho más concisa
    // Donde el comportamiento se traslada al controller
    app.routes {
        path("lugares") {
            get(geoController::getAll)
            post(geoController::addPlace)
            path(":id") {
                get(geoController::getPlace)
                put(geoController::updatePlace)
                delete(geoController::deletePlace)
            }
        }
    }
}
