package unq.edu.uis.windows

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import unq.edu.uis.tvSeries.domain.Serie
import unq.edu.uis.tvSeries.domain.TvSeriesSystem

@Observable
@Accessors
class CrearSeriesAppModel {
	Serie serie
	TvSeriesSystem sistema 
	
	new(TvSeriesSystem sistema){
		this.sistema = sistema
		serie = new Serie
	}
	
	def agregarMateria(){
		sistema.agregarSerie(serie)
}
}