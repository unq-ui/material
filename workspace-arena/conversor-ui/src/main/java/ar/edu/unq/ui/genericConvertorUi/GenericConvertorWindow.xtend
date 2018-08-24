package ar.edu.unq.ui.genericConvertorUi

import ar.edu.unq.ui.genericConvertor.Conversion
import java.awt.Color
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.NumericField
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.MainWindow

import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import ar.edu.unq.ui.genericConvertor.GenericConverter

/**
 * Conversor generico que permite diversas operaciones de 
 * conversion.
 */
class GenericConvertorWindow  extends MainWindow<GenericConverter> {
	
	new() {
		super(new GenericConverter)
	}

	override createContents(Panel mainPanel) {
		this.title = "Conversor genérico"
		mainPanel.layout = new VerticalLayout
		
		new ErrorsPanel(mainPanel, "Listo para convertir")

		new Label(mainPanel).text = "De:"

		new NumericField(mainPanel).value <=> "input"
		
		new List(mainPanel) => [
			allowNull(false)
			(items <=> "possibleConversions").adapter = nameAdapter
			value <=> "conversion"
		]

		new Button(mainPanel) => [ 
			caption = "Convertir"
			onClick [ | modelObject.convert ]
			bindEnabled(new NotNullObservable("conversion"))
		]
		
		new Label(mainPanel).text = "A: "	
		new Label(mainPanel) => [
			background = Color.ORANGE
			value <=> "output"
		]
	}
	
	def nameAdapter() {
		new PropertyAdapter(typeof(Conversion), "name")
	}

	def static main(String[] args) {
		new GenericConvertorWindow().startApplication
	}
	
}