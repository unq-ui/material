package unq.edu.uis.tvSeries_xtrest.server

import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.annotation.Post
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.json.JSONUtils
import org.uqbar.xtrest.api.annotation.Delete
import unq.edu.uis.animeList.model.AnimeSystem
import org.uqbar.xtrest.api.annotation.Put
import unq.edu.uis.animeList.model.Anime

/**
 * Servidor RESTful implementado con XtRest.
 */
@Controller
class RestfulServer {

	extension JSONUtils = new JSONUtils

	AnimeSystem animeSystem

	new(AnimeSystem animeSystem) {
		this.animeSystem = animeSystem
	}

	/**
	 * Permite obtener 30 animes de la pagina {page}
	 */
	@Get("/animes")
	def getAnimes(String page) {
		response.contentType = ContentType.APPLICATION_JSON
		val integerPage = Integer.valueOf(page ?: '1')
		return ok(new AnimeList(this.animeSystem, integerPage).toJson)
	}


	/**
	 * Permite agregar un nuevo anime
	 */
	@Put("/anime")
	def addNewAnime(@Body String body) {
		response.contentType = ContentType.APPLICATION_JSON
		val anime = body.fromJson(Anime)
		this.animeSystem.addAnime(anime)
		return ok()
	}

	/**
	 * Permite modificar un anime
	 */
	@Post("/anime")
	def editAnime(@Body String body) {
		response.contentType = ContentType.APPLICATION_JSON
		val updateAnime = body.fromJson(Anime)
		this.animeSystem.editAnime(updateAnime.id, updateAnime)
		return ok()
	}


	/**
     * Permite eliminar un anime por su id.
     */
    @Delete('/anime/:id')
    def deleteAnimeById() {
		response.contentType = ContentType.APPLICATION_JSON
        val eliminadoOk = this.animeSystem.removeAnime(Integer.valueOf(id))
        return if (eliminadoOk) ok() else badRequest(getErrorJson("No existe el anime con identificador " + id))
    }
    
	/**
     * Permite obtener un anime por su id.
     */
    @Get('/anime/:id')
    def getAnimeById() {
		response.contentType = ContentType.APPLICATION_JSON
        return ok(this.animeSystem.getAnime(Integer.valueOf(id)).toJson)
    }
    
	private def getErrorJson(String message) {
		'{ "error": "' + message + '" }'
	}
	
	@Get('/animes/:text')
	def searchAnime() {
		response.contentType = ContentType.APPLICATION_JSON
		return ok(this.animeSystem.search(text).toJson)
	}

}
