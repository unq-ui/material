package unquify

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

@Accessors
@Observable
class UnquifyController(var unquify: Unquify) {
	var filteredSongs: MutableList<Song> = unquify.songs.toMutableList()
	var selectedSong: Song? = null
	var filter: String? = ""
		set(value) {
			field = value.toString().toLowerCase()
			search()
		}

	fun search() {
		filteredSongs = unquify.songs
				.filter { it.name.toLowerCase().contains(filter.toString()) }.toMutableList()
	}
	
	fun addSong(song: Song) {
		unquify.addSong(song)
		search()
	}
	
}