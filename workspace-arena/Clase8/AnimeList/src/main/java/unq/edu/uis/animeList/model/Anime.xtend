package unq.edu.uis.animeList.model

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Anime {
	
	Integer id
	String title
	String urlDetails
	String image
	String type
	Integer episodes
	String startDate
	String endDate
	Integer members
	Integer score
	
	def updateWith(Anime anime) {
		this.title = anime.title
		this.urlDetails = anime.urlDetails
		this.image = anime.image
		this.type = anime.type
		this.episodes = anime.episodes
		this.startDate = anime.startDate
		this.endDate = anime.endDate
		this.members = anime.members
		this.score = anime.score
	}
	
}
