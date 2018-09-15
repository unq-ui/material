package unq.edu.uis.tvSeries.domain

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

@Accessors
@Observable
class TvSeriesSystem {
	List<Serie> series
	
	def void agregarSerie(Serie serie){
		series.add(serie)
	}
	def void borrarSerie(Serie serie){
		series.remove(serie)
	}
}