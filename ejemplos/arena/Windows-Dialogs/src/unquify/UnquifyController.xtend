package unquify

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import java.util.List

@Accessors
@Observable
class UnquifyController {
	
	Unquify unquify
	List<Song> filteredSongs
	String filter
	Song selectedSong
	
	new(Unquify unquify){
		this.unquify = unquify
		this.filter = ""
		filteredSongs = unquify.songs
	}
	
	def void setFilter(String newFilter) {
		this.filter = newFilter.toLowerCase
		buscar()
	}
	
	def buscar() {
		this.filteredSongs = unquify.songs.filter[it.name.toLowerCase.contains(filter)].toList
	}
	
	def addSong(Song song) {
		unquify.addSong(song)
		buscar()
	}
	
}