package unq.edu.uis.tvSeries.domain


import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

@Accessors
@Observable
class Actor {
	String nombre
	String personaje
}