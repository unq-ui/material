package tvSeries.model

import tvSeries.Actor
import tvSeries.Serie
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable


@Observable
@Accessors
class ActorAppModel(val actor: Actor?) {
	var name: String? = actor?.name
	var character: String? = actor?.character
	var serie: Serie? = actor?.serie

	fun model() = actor
}