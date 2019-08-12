package tvSeries.view

import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import tvSeries.model.TvSeriesAppModel

fun main() = TvSeriesApplication().start()

class TvSeriesApplication : Application() {
	override fun createMainWindow(): Window<*> = TvSeriesWindow(this, TvSeriesAppModel())
}
