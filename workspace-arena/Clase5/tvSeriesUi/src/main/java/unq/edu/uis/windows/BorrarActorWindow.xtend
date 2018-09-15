package unq.edu.uis.windows

import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*

class BorrarActorWindow extends Dialog<BorrarActorAppModel> {
	
	new(WindowOwner owner, BorrarActorAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Borrar Actor"
		mainPanel.layout = new VerticalLayout 
		
		new Label(mainPanel).text = "Realmente desea borrar este actor?"
		new Label(mainPanel)=> [
			value <=> "actor.nombre"
		]
		new Label(mainPanel)=> [
			value <=> "actor.personaje"
		]
		val panelBotonera = new Panel (mainPanel)
		panelBotonera.layout = new HorizontalLayout
		new Button(panelBotonera)=>[
			caption = "Cancelar"
			onClick [ |
				this.close
			]
		]
		new Button(panelBotonera)=>[
			caption = "Aceptar"
			onClick [ |
				this.modelObject.borrarActor
				this.close
			]
		]
	}
	
}