package unq.edu.uis.tvSeriesUi

import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import unq.edu.uis.tvSeries.domain.Actor
import unq.edu.uis.tvSeries.domain.Serie

import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import unq.edu.uis.windows.NuevaSerieWindow
import unq.edu.uis.windows.BorrarActorWindow
import unq.edu.uis.windows.BorrarActorAppModel

class TvSeriesWindow extends SimpleWindow<TvSeriesAppModel>{
	
	new(WindowOwner parent, TvSeriesAppModel model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		//NO se usara este default
	}
	
	override protected createFormPanel(Panel mainPanel) {
		//NO se usara este default
	}
	override createMainTemplate(Panel mainPanel) {
		this.title = "TV Series"
		mainPanel.layout = new HorizontalLayout
		this.crearPanelListadoDeSeries(mainPanel)
		this.crearPanelEdicionDeSerieSeleccionada(mainPanel)
	}
	
	def crearPanelListadoDeSeries(Panel owner) {
		var panelListadoDeSeries = new Panel(owner)
		panelListadoDeSeries.layout = new VerticalLayout
		new Label(panelListadoDeSeries).text = "Series"
		new List<Serie>(panelListadoDeSeries)=>[
			value <=> "serieSeleccionada"
			(items <=> "sistema.series").adapter = new PropertyAdapter(Serie, "nombre")
		]
		new Button(panelListadoDeSeries) =>[
			caption = "Nueva Serie"
			onClick [ | new NuevaSerieWindow(this, this.modelObject.sistema).open ]
		] 
	}
	def crearPanelEdicionDeSerieSeleccionada(Panel owner) {
		var panelEdicionDeSerieSeleccionada = new Panel(owner)
		this.crearPanelPresentacionSerie(panelEdicionDeSerieSeleccionada)
		
		
		
		val tablaDeActores = new Table<Actor>(panelEdicionDeSerieSeleccionada, Actor) => [
			items <=> "serieSeleccionada.actores"
			value <=> "actorSeleccionado"
		]
		
		new Column(tablaDeActores)=>[
			title = "Nombre"
			bindContentsToProperty("nombre")
		]
		
		new Column(tablaDeActores)=>[
			title = "Personaje"
			bindContentsToProperty("personaje")
		]
		new Button(panelEdicionDeSerieSeleccionada) => [
			caption = "Borrar actor"
			onClick [|new BorrarActorWindow(this, new BorrarActorAppModel(this.modelObject.actorSeleccionado,this.modelObject.serieSeleccionada)).open]
		]
		this.crearPanelBotonera(panelEdicionDeSerieSeleccionada)
		
	}
	def crearPanelPresentacionSerie(Panel owner){
		var panelPresentacionSerie = new Panel(owner)
		panelPresentacionSerie.layout = new ColumnLayout(2)
		new Label(panelPresentacionSerie).text="Nombre:"
		new TextBox(panelPresentacionSerie).value <=> "serieSeleccionada.nombre"
		
		new Label(panelPresentacionSerie).text = "Temporadas:"
		new TextBox(panelPresentacionSerie).value <=> "serieSeleccionada.temporadas"
	}
	def crearPanelBotonera(Panel owner){
		var panelBotonera = new Panel(owner)
		panelBotonera.layout = new HorizontalLayout
		new Button(panelBotonera) => [
			caption = "Aceptar"
			onClick [|/*new EditarNotaWindow(this, this.modelObject.notaSeleccionada).open*/]
		]
			
		new Button(panelBotonera)=>[
			caption = "Cancelar"
			onClick [| 
				
			]
		]
		
		new Button(panelBotonera) => [
			caption="Agregar actor"
			onClick [| 
				
			]
		]
	}
	def static void main(String[] args) {
		new TvSeriesWindow().start()
}
}