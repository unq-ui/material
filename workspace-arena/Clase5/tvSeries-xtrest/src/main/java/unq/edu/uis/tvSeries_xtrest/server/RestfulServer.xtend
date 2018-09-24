package unq.edu.uis.tvSeries_xtrest.server

import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.annotation.Post
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.json.JSONUtils
import unq.edu.uis.tvSeries.domain.Actor
import unq.edu.uis.tvSeries.domain.TvSeriesSystem
import org.uqbar.xtrest.api.annotation.Delete

/**
 * Servidor RESTful implementado con XtRest.
 */
@Controller
class RestfulServer {

	extension JSONUtils = new JSONUtils

	TvSeriesSystem tvSeriesSystem

	new(TvSeriesSystem tvSeriesSystem) {
		this.tvSeriesSystem = tvSeriesSystem
	}

	/**
	 * Permite obtener el listado total de las series
	 */
	@Get("/series")
	def getSeries() {

		response.contentType = ContentType.APPLICATION_JSON

		return ok(this.tvSeriesSystem.series.toJson)
	}


	/**
	 * Permite agregar un actor (con nombre y persona) a la serie informada por parámetro
	 */
	@Post("/series/:nombreSerie/:nombreActor/:personaje")
	// http://0.0.0.0:9000/series/breaking/pepe/pepe
	def agregarActor() {
		response.contentType = ContentType.APPLICATION_JSON
		try {

			val actor = new Actor()
			actor.nombre = nombreActor
			actor.personaje = personaje
			val serie = this.tvSeriesSystem.buscarSerie(nombreSerie);
			serie.agregarActor(actor)
			return ok()
		} catch (Exception exception) {
			return badRequest(getErrorJson(exception.message + " No existe la serie con nombre: " + nombreSerie))
		}
	}

	/**
	 * Permite agregar un actor a la serie informada por parámetro. El actor debe ser enviado en el body del mensaje
	 */
	@Post("/series/:nombreSerie") 
	// http://0.0.0.0:9000/series/Breaking
	// Body [ { "nombre" : "as", "personaje" : "as" }]
	def agregarActor(@Body String body) {
		response.contentType = ContentType.APPLICATION_JSON
		try {
			val actor = body.fromJson(Actor)

			val serie = this.tvSeriesSystem.buscarSerie(nombreSerie);
			serie.agregarActor(actor)
			return ok()
		} catch (Exception exception) {
			return badRequest(getErrorJson(exception.message + " No existe la serie con nombre: " + nombreSerie))
		}
	}


	/**
     * Permite eliminar un serie por su id.
     * 
     * Atiende requests de la forma DELETE /series/1.
     */
    @Delete('/series/:id')
    def deleteSerieById() {
        try {
            val eliminadoOk = this.tvSeriesSystem.eliminarSeriePorId(Integer.valueOf(id))
            return if (eliminadoOk) ok() else badRequest(getErrorJson("No existe la serie con identificador " + id))
        } catch (NumberFormatException exception) {
            return badRequest(getErrorJson("El id debe ser un número entero"))
        }
    }
    
	private def getErrorJson(String message) {
		'{ "error": "' + message + '" }'
	}

}
