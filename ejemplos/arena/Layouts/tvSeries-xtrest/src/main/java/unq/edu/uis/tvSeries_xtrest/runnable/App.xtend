package unq.edu.uis.tvSeries_xtrest.runnable

import org.uqbar.xtrest.api.XTRest
import unq.edu.uis.tvSeries.domain.TvSeriesSystem
import unq.edu.uis.tvSeries.dummyData.DummyData
import unq.edu.uis.tvSeries_xtrest.server.RestfulServer

class App {
	
	def static void main(String[] args) {
		val series = new DummyData().seriesDummy;
		val tvSeriesSystem = new TvSeriesSystem();
		tvSeriesSystem.series = series
        XTRest.startInstance(9000, new RestfulServer(tvSeriesSystem))
    }
}