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

    // Instancio el controller
    // Le agrego data para poder probar inicialmente
    val geoController = GeoController()
    geoController.addPlace(Geo(-34.706272, -58.278519, "UNQ"))
    geoController.addPlace(Geo(-34.709390, -58.280507, "Bernal"))
    geoController.addPlace(Geo(-34.603595, -58.381717, "Obelisco"))

    // CRUD de Lugares
    // Sintaxis alternativa, más concisa
    app.routes {
        path("lugares") {
            get { ctx ->
                ctx.json(geoController.getAll())
            }
            post { ctx ->
                // Capturo el error con app.exception al inicializar la application
                ctx.status(CREATED_201)
                val geo = ctx.body<Geo>()
                ctx.json(geoController.addPlace(geo))
            }
            path(":id") {
                get { ctx ->
                    val id = ctx.pathParam("id").toInt()
                    ctx.json(geoController.getPlace(id))
                }
                put { ctx ->
                    val id = ctx.pathParam("id").toInt()
                    val newGeo = ctx.body<Geo>()
                    ctx.json(geoController.updatePlace(id, newGeo))
                }
                delete { ctx ->
                    ctx.status(NO_CONTENT_204)
                    val id = ctx.pathParam("id").toInt()
                    geoController.deletePlace(id)
                }
            }
        }
    }
}
