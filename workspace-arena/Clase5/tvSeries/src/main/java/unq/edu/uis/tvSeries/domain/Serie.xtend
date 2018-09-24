package unq.edu.uis.tvSeries.domain

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

@Accessors
@Observable
class Serie {
	int id
	String nombre
	int temporadas
	
	
	List<Actor> actores
	
	new() { 
		actores = newArrayList
	}
	
	def void agregarActor(Actor actor){
		actores.add(actor)
	}
	def void borrarActor(Actor actor){
		actores.remove(actor)
	}
}