package unq.edu.uis.windows

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import unq.edu.uis.tvSeries.domain.Actor
import unq.edu.uis.tvSeries.domain.Serie

@Observable
@Accessors
class BorrarActorAppModel {
	
	Serie serie
	Actor actor 
	
	new(Actor actor, Serie serie){
		this.actor = actor
		this.serie = serie
	}
	
	def borrarActor(){
		serie.borrarActor(actor)
}
}