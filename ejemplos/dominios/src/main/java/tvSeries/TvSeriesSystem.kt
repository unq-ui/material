package tvSeries

class TvSeriesSystem {
	val series = mutableListOf<Serie>()

	fun addSerie(serie: Serie?) {
		if (serie == null) return
		series.add(serie)
	}

	fun removeActorFromSerie(actor: Actor?, serie: Serie?) {
		if (actor == null || serie == null) return
		series.firstOrNull { it.actors.contains(actor) }?.removeActor(actor)
	}

	fun removeSerie(serie: Serie?) = series.remove(serie)

	fun searchSerie(text: String) =
			series.firstOrNull { it.name.toLowerCase().contains(text.toLowerCase()) }

	fun removeSerieById(id: Int) = series.removeIf { it.id == id }
}
