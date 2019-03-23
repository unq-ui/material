package unq.edu.uis.animeList_xtrest.runnable

import org.uqbar.xtrest.api.XTRest
import unq.edu.uis.tvSeries_xtrest.server.RestfulServer
import unq.edu.uis.bootstrap.BootstrapAnimeSystem

class App {
	
	def static void main(String[] args) {
		val animeList = BootstrapAnimeSystem.createAnimeSystem
		XTRest.startInstance(9000, new RestfulServer(animeList))
    }
}