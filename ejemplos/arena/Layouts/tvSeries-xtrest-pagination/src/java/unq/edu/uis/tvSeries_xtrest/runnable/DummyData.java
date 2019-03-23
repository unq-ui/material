package unq.edu.uis.tvSeries_xtrest.runnable;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import unq.edu.uis.tvSeries.domain.Serie;
import unq.edu.uis.tvSeries.domain.Actor;

public class DummyData {

	public static List<Serie> crearSeries() throws Exception {
		List<Serie> series = new ArrayList<>();
		FileReader file = new FileReader("./series.json");
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode list = (ArrayNode) mapper.readTree(file);
		list.forEach(object -> {
			Serie s = new Serie();
			s.setId(series.size()+1);
			s.setNombre(object.get("nombre").textValue());
			s.setTemporadas(object.get("temporada").intValue());
			ArrayNode actoresJson = (ArrayNode) object.get("actores");
			actoresJson.forEach(nombre -> {
				Actor actor = new Actor();
				actor.setNombre(nombre.textValue());
				actor.setPersonaje(nombre.textValue());
				s.agregarActor(actor);
			});
			series.add(s);
		});
		return series;
	}
	
}
