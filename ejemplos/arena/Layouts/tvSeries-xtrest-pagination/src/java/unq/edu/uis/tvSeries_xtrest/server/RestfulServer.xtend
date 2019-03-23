package unq.edu.uis.tvSeries_xtrest.server

import org.uqbar.xtrest.json.JSONUtils
import unq.edu.uis.tvSeries.domain.TvSeriesSystem
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.api.annotation.Controller

@Controller
class RestfulServer {
	
	extension JSONUtils = new JSONUtils

	TvSeriesSystem tvSeriesSystem

	new(TvSeriesSystem tvSeriesSystem) {
		this.tvSeriesSystem = tvSeriesSystem
	}
	
	@Get("/allSeries")
	def getSeries() {
		response.addHeader("Access-Control-Allow-Origin", "*")
		response.contentType = ContentType.APPLICATION_JSON
		return ok(this.tvSeriesSystem.series.toJson)
	}
	
	@Get("/fixedSeries")
	def getFixedDataPagesSeries(String page) {
		response.addHeader("Access-Control-Allow-Origin", "*")
		val pageInt = new Integer(page)
		val amountPerPage = 10
		response.contentType = ContentType.APPLICATION_JSON
		return ok(this.tvSeriesSystem.series.subList((pageInt -1) * amountPerPage, (pageInt -1) * amountPerPage + amountPerPage).toJson)
	}
	
	@Get("/flexibleSeries")
	def getFlexibleDataPagesSeries(String page, String page_size) {
		response.addHeader("Access-Control-Allow-Origin", "*")
		val pageInt = new Integer(page)
		val amountPerPage = new Integer(page_size)
		response.contentType = ContentType.APPLICATION_JSON
		return ok(this.tvSeriesSystem.series.subList((pageInt -1) * amountPerPage, (pageInt -1) * amountPerPage + amountPerPage).toJson)
	}
	
	@Get("/offsetSeries")
	def getOffsetAndCountSeries(String offset, String count) {
		response.addHeader("Access-Control-Allow-Origin", "*")
		val offsetInt = new Integer(offset)
		val countInt = new Integer(count)
		response.contentType = ContentType.APPLICATION_JSON
		return ok(this.tvSeriesSystem.series.subList(offsetInt, offsetInt + countInt).toJson)
	}
	
}
