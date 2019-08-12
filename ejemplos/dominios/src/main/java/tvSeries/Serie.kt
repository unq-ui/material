package tvSeries

data class Serie(val id: Int, val name: String, var seasons: Int = 0) {
	val actors = mutableListOf<Actor>()
	
	fun addActor(actor: Actor) = actors.add(actor)
	fun removeActor(actor: Actor) = actors.remove(actor)
}