package ar.edu.unq.ui.ejemploVentanaDialogo_UI

import ar.edu.unq.ui.ejemploVentanaDialogo.BasicConverter
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner

class PruebaVentana extends SimpleWindow<BasicConverter> {
	
	new(WindowOwner parent, BasicConverter model) {
		super(parent, model)
	}


	override protected void addActions(Panel actionsPanel) { // TODO Auto-generated method stub
	}

	override protected void createFormPanel(Panel mainPanel) {
	}
	
	override createMainTemplate(Panel mainPanel) {
		this.title = "Componente SimpleWindow"
		mainPanel.layout = new VerticalLayout
				
		//Agregamos el contenido
		val Panel contentPanel = new Panel(mainPanel)
		contentPanel.layout = new ColumnLayout(2)
		new Button(contentPanel) =>[
			caption = "Abrir Dialog"
			onClick [ | new PruebaDialog(this, this.modelObject).open ]
		] 
	}
}
