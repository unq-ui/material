package ar.edu.unq.ui.conversorUi

import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.MainWindow

import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import ar.edu.unq.ui.conversor.SynchronizedConverter

/**
 * Variante del conversor bidireccional.
 * Es decir que permite convertir millas a km pero también de km a millas.
 * Para esto, no utiliza ningun boton, sino que convierte instantaneamente a medida que se
 * va ingresando el valor en uno de los dos textfields.
 */
class SynchronizedConvertorWindow extends MainWindow<SynchronizedConverter> {
	
	new() {
		super(new SynchronizedConverter)
	}

	override createContents(Panel mainPanel) {
		this.title = "Conversor sincronizado"
		mainPanel.layout = new VerticalLayout
		
		new ErrorsPanel(mainPanel, "Listo para convertir")

		new Label(mainPanel).text = "Millas:"
		new TextBox(mainPanel).value <=> "miles"
		
		new Label(mainPanel).text = "Kilometros:"
		new TextBox(mainPanel).value <=> "kilometers"
	}

	def static main(String[] args) {
		new SynchronizedConvertorWindow().startApplication
	}
	
}