package unquify

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.annotations.Transactional
import org.uqbar.commons.model.Entity

@Accessors
@Observable
class Unquify(var songs: MutableList<Song>) {
	fun addSong(newSong: Song) = songs.add(newSong)
}

@Accessors
@Observable
@Transactional
class Song(var name: String = "", var duration: Int = 0, var band: String = "") : Entity() {
	fun minDuration() =
			"${duration / 60}:${String.format("%02d", duration % 60)}"
}

object UnquifyFactory {
	fun get(): Unquify {
		val s1 = Song("Californication", 321, "Red Hot Chili Peppers")
		val s2 = Song("Snow", 350, "Red Hot Chili Peppers")
		val s3 = Song("Do I Wanna Know?", 266, "Arctic Monkeys")
		val s4 = Song("Numb", 187, "Linkin Park")
		return Unquify(mutableListOf(s1,s2,s3,s4))
	}
}
