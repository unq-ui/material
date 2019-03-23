package ar.edu.unq.ui.ejemploVentanaDialogo_UI

import ar.edu.unq.ui.ejemploVentanaDialogo.BasicConverter

import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button

class PruebaDialog extends Dialog<BasicConverter> {
	
	new(WindowOwner owner, BasicConverter model) {
		super(owner, new BasicConverter())
	}
	
	override protected void createFormPanel(Panel owner) {
		this.title = "Componente Dialog"
		var mainPanel = new Panel(owner)
		mainPanel.layout = new ColumnLayout(2)
		new Label(mainPanel).text = {
		"Dialogo"
			
		}
		
		new Button(mainPanel) => [
			caption = "Cerrar Dialogo"
			onClick [|this.close]
		]
	}
}
