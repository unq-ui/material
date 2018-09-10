package unquify

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.annotations.Transactional
import org.uqbar.commons.model.Entity

@Accessors
@Observable
class Unquify {
	
	List<Song> songs
	
	new(List<Song> songs) {
		this.songs = songs
	}
	
	def addSong(Song newSong) {
		songs.add(newSong)
	}
	
}

@Accessors
@Observable
@Transactional
class Song extends Entity {
	
	String name
	Integer duration
	String band
	
	new(){
		name = ""
		duration = 0
		band = ""
	}
	
	new(String name, Integer duration, String band) {
		this.name = name
		this.duration = duration
		this.band = band
	}

	def minDuration() {
		'''«duration / 60»:«String.format("%02d", duration % 60)»'''	
	}
	
}

class UnquifyFactory {
	
	def static get() {
		val s1 = new Song("Californication", 321, "Red Hot Chili Peppers")
		val s2 = new Song("Snow", 350, "Red Hot Chili Peppers")
		val s3 = new Song("Do I Wanna Know?", 266, "Arctic Monkeys")
		val s4 = new Song("Numb", 187, "Linkin Park")
		new Unquify(newArrayList(s1,s2,s3,s4)) 
	}
}
