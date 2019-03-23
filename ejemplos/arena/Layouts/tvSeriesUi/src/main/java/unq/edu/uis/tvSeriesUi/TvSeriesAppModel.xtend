package unq.edu.uis.tvSeriesUi

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import unq.edu.uis.tvSeries.domain.Actor
import unq.edu.uis.tvSeries.domain.Serie
import unq.edu.uis.tvSeries.domain.TvSeriesSystem
import unq.edu.uis.tvSeries.dummyData.DummyData

@Accessors
@Observable
class TvSeriesAppModel {
	TvSeriesSystem sistema
	Serie serieSeleccionada
	Actor actorSeleccionado
	
	new(){
		sistema = new TvSeriesSystem => [
			series=new DummyData().seriesDummy
			]
		serieSeleccionada = sistema.series.get(0)
		actorSeleccionado = serieSeleccionada.actores.get(0)
	}
}