package unq.edu.uis.bootstrap

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.FileInputStream
import unq.edu.uis.animeList.model.AnimeSystem

class BootstrapAnimeSystem {
		
	def static createAnimeSystem() {
		val mapper = new ObjectMapper();
		try{
			val fileStream = new FileInputStream("src/main/resources/animeList.json")
    		return mapper.readValue(fileStream, AnimeSystem);
		}catch(Exception e) {
			println(e)
			return new AnimeSystem
		}
		
	}
	
}
