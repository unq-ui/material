package timeCounter

import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.Panel
import model.TimeCounter
import org.uqbar.arena.widgets.Label
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.* 
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.layout.HorizontalLayout

class TimeCounterWindow extends MainWindow<TimeCounter>{
	
	new(TimeCounter model) {
		super(model)
	}
	
	override createContents(Panel mainPanel) {
		this.title = "Cantidad de Días"
		this.minWidth = 250
		
		new Panel(mainPanel) => [
			layout = new HorizontalLayout
			new Label(it) => [
				text = "Hoy es:"
			]
			new Label(it) => [
				value <=> "now"
			]
		]
		
		new Panel(mainPanel) => [
			layout = new HorizontalLayout
			new Label(it) => [
				text = "Fecha:"
			]
			new TextBox(it) => [
				withFilter(new LocalDateFilter)
				(value <=> "anotherDate").transformer = new LocalDateTransformer
			]
		]
		
		new Label(mainPanel) => [
			text = "_______Modelo_______"
		]
		
		new Panel(mainPanel) => [
			layout = new HorizontalLayout
			new Label(it) => [
				text = "AnotherDate:"
			]
			new Label(it) => [
				value <=> "anotherDate"
			]
		]

	}
	
	def static void main(String[] args) {
		new TimeCounterWindow(new TimeCounter()).startApplication
	}
	
}
