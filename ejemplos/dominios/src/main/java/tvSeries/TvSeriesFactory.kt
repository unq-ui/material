package tvSeries

/**
 * This object retrieve an instance of TvSeriesSystem with some data
 */
object TvSeriesFactory {
	private val tvSeriesSystem = TvSeriesSystem()
	init {
		tvSeriesSystem.addSerie(makeBreakingBad())
		tvSeriesSystem.addSerie(makeGameOfThrones())
		tvSeriesSystem.addSerie(makeVikings())
	}
	fun makeTvSeriesSystem() = tvSeriesSystem
	
	private fun makeBreakingBad(): Serie {
		val serie = Serie(id = 1, name = "Breaking Bad", seasons = 5)
		serie.addActor(Actor("Bryan Cranston", "Walter White", serie))
		serie.addActor(Actor("Aaron Paul", "Jesse Pinkman", serie))
		serie.addActor(Actor("Bob Odenkirk", "Saul Goodman", serie))
		return serie
	}

	private fun makeGameOfThrones(): Serie {
		val serie = Serie(id = 2, name = "Game of Thrones", seasons = 7)
		serie.addActor(Actor("Kit Harington","Jon Snow", serie))
		serie.addActor(Actor("Emilia Clarke","Daenerys Targaryen", serie))
		serie.addActor(Actor("Lena Headey","Cersei Lannister", serie))
		return serie
	}

	private fun makeVikings(): Serie {
		val serie = Serie(id = 3, name = "Vikings", seasons = 5)
		serie.addActor(Actor("Travis Fimmel","Ragnar Lothbrok", serie))
		serie.addActor(Actor("Katheryn Winnick","Lagertha", serie))
		serie.addActor(Actor("Alexander Ludwig","Björn Lothbrok", serie))
		return serie
	}
}
