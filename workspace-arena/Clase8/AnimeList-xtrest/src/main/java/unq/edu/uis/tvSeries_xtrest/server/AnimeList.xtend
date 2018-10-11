package unq.edu.uis.tvSeries_xtrest.server

import java.util.List
import unq.edu.uis.animeList.model.Anime
import unq.edu.uis.animeList.model.AnimeSystem
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class AnimeList {
	
	List<Anime> data
	Integer currentPage
	Integer amountOfPages
	
	new(AnimeSystem system, Integer currentPage) {
		this.data = system.getPage(currentPage)
		this.currentPage = currentPage
		this.amountOfPages = system.amountOfPages	
	}
	
	
}