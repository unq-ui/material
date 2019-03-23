package unq.edu.uis.tvSeries.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

@Accessors
@Observable
class Actor {
	String nombre
	String personaje
	@JsonBackReference
	Serie serie

	def void agregarSerie(Serie serie) {
		this.serie = serie
	}
}
