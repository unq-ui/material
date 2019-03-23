package unq.edu.uis.tvSeries.dummyData

import unq.edu.uis.tvSeries.domain.Actor
import unq.edu.uis.tvSeries.domain.Serie

class DummyData {
	
	def seriesDummy(){
		newArrayList =>[
			add(breakingBad)
			add(gameOfThrones)
			add(vikings)
		]
	}
	
	def Serie breakingBad (){
		val serie = new Serie =>[
			id = 1
			nombre = "Breaking Bad"
			temporadas = 5
		]
		 serie.actores = actoresBreakingBad(serie)
		 return serie
	}
	def Serie gameOfThrones (){
		new Serie =>[
			id = 2
			nombre = "Game of Thrones"
			temporadas = 7
			actores = actoresGameOfThrones
		]
	}
	def Serie vikings (){
		new Serie =>[
			id = 3
			nombre = "Vikings"
			temporadas = 5
			actores = actoresVikings
		]
	}
	def actoresBreakingBad(Serie serie){
		val actor1 = crearActor("Bryan Cranston","Walter White")
		actor1.agregarSerie(serie)
		val actor2 =crearActor("Aaron Paul","Jesse Pinkman")
		actor2.agregarSerie(serie)
		val actor3 =crearActor("Bob Odenkirk","Saul Goodman")
		actor3.agregarSerie(serie)
		return newArrayList =>[
			add(actor1)
			add(actor2)
			add(actor3)
		]
		
	}
	def actoresGameOfThrones(){
		newArrayList =>[
			add(crearActor("Kit Harington","Jon Snow"))
			add(crearActor("Emilia Clarke","Daenerys Targaryen"))
			add(crearActor("Lena Headey","Cersei Lannister"))
		]
	}
	def actoresVikings(){
		newArrayList =>[
			add(crearActor("Travis Fimmel","Ragnar Lothbrok"))
			add(crearActor("Katheryn Winnick","Lagertha"))
			add(crearActor("Alexander Ludwig","Björn Lothbrok"))
		]
	}
	def crearActor (String nombre, String personaje){
		new Actor =>[
			it.nombre =nombre
			it.personaje = personaje
		]
	}
}