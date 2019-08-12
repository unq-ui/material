package tvSeries.model

import tvSeries.TvSeriesSystem
import tvSeries.TvSeriesFactory
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.exceptions.UserException

@Accessors
@Observable
class TvSeriesAppModel {
	private val system: TvSeriesSystem = TvSeriesFactory.makeTvSeriesSystem()
	var series = initSeries()
	var selectedSerie: SerieAppModel? = null
	var selectedActor: ActorAppModel? = null

	fun removeSelectedActor() {
		if (selectedActor == null) throw UserException("No se seleccionó Actor o Serie")

		system.removeActorFromSerie(selectedActor!!.model(), selectedActor!!.serie)
		series = initSeries()
	}

	private fun initSeries() = system.series.map { SerieAppModel(it) }.toMutableList()
	fun addNewSerie(serie: SerieAppModel): Unit {
		if (serie.name == null || serie.seasons == null)
			throw UserException("Falta el nombre o las temporadas")

		system.addSerie(serie.model())
		series = initSeries()
	}
}
