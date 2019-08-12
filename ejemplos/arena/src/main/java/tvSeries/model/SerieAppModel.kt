package tvSeries.model

import tvSeries.Serie
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException

@Observable
@Accessors
data class SerieAppModel(var serie: Serie?) {
	var id: Int? = serie?.id
	var name: String? = serie?.name
	var seasons: Int? = serie?.seasons
	var actors: MutableList<ActorAppModel>? = serie?.actors?.map { ActorAppModel(it) }?.toMutableList()

	fun model() = serie
	fun createSerie() {
		if (name == null || seasons == null)
			throw UserException("Debe completar los datos")

		id = 42
		serie = Serie(id!!, name!!, seasons!!)
	}
}