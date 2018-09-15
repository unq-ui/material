package unq.edu.uis.windows

import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import unq.edu.uis.tvSeries.domain.TvSeriesSystem

import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*

class NuevaSerieWindow extends Dialog<CrearSeriesAppModel> {
	
	new(WindowOwner owner, TvSeriesSystem model) {
		super(owner, new CrearSeriesAppModel(model))
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Nueva Serie"
		mainPanel.layout = new VerticalLayout 
		
		new Label(mainPanel).text = "Nombre:"
		new TextBox(mainPanel) => [
			value <=> "serie.nombre"
			width = 200
		]
		new Label(mainPanel).text = "Temporadas:"
		new TextBox(mainPanel) => [
			value <=> "serie.temporadas"
			width = 200
		]
		new Button(mainPanel)=>[
			caption = "Aceptar"
			onClick [ |
				this.modelObject.agregarMateria
				this.close
			]
		]
	}
	
}