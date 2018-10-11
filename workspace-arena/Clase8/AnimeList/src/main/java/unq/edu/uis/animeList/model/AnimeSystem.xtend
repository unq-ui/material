package unq.edu.uis.animeList.model

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class AnimeSystem {
	
	List<Anime> animes;
	Integer default_amountForPage = 30
	
	def getPage(Integer numberPage) {
		val start = (numberPage -1) * default_amountForPage
		val end = start + default_amountForPage
		return animes.subList(start, end)
	}
	
	def amountOfPages() {
		this.animes.size / this.default_amountForPage
	}
	
	def addAnime(Anime anime) {
		val lastAnime = this.animes.last
		if(lastAnime === null) {
			anime.id = 1
		} else {
			anime.id = lastAnime.id +1
		}
		this.animes.add(anime)
	}
	
	def removeAnime(Integer id) {
		this.animes.remove(this.animes.findFirst[it.id == id])
	}
	
	def editAnime(Integer id, Anime newAnime) {
		val oldAnime = this.animes.findFirst[it.id == id]
		if(oldAnime === null) {
			throw new RuntimeException("Anime no existente")
		}
		oldAnime.updateWith(newAnime)
	}
	
	def search(String text) {
		return this.animes.filter[it.title.contains(text)].toList
	}
	
	def getAnime(Integer id) {
		return this.animes.findFirst[it.id == id]
	}
}
