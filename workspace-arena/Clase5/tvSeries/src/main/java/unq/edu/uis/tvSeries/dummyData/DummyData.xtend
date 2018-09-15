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
		new Serie =>[
			nombre = "Breaking Bad"
			temporadas = 5
			actores = actoresBreakingBad
		]
	}
	def Serie gameOfThrones (){
		new Serie =>[
			nombre = "Game of Thrones"
			temporadas = 7
			actores = actoresGameOfThrones
		]
	}
	def Serie vikings (){
		new Serie =>[
			nombre = "Vikings"
			temporadas = 5
			actores = actoresVikings
		]
	}
	def actoresBreakingBad(){
		newArrayList =>[
			add(crearActor("Bryan Cranston","Walter White"))
			add(crearActor("Aaron Paul","Jesse Pinkman"))
			add(crearActor("Bob Odenkirk","Saul Goodman"))
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