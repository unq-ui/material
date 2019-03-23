package person

import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label

import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.widgets.TextBox
import java.time.LocalDate
import org.uqbar.arena.windows.ErrorsPanel
import timeCounter.LocalDateTransformer

class PersonWindow extends MainWindow<Person> {
	
	new(Person model) {
		super(model)
	}
	
	override createContents(Panel mainPanel) {
		this.title = "Persona"
		
		new Label(mainPanel) => [
			text = "Nombre:"
		]
		
		new TextBox(mainPanel) => [
			value <=> "name"
		]
		
		new Label(mainPanel) => [
			text = "Telefono:"
		]
		
		new TextBox(mainPanel) => [
			withFilter(new PhoneFilter)
			(value <=> "phone").transformer = new PhoneTransformer
		]
		
		new Label(mainPanel) => [
			text = "Fecha de nacimiento:"
		]
		
		new TextBox(mainPanel) => [
			(value <=> "birthday").transformer = new LocalDateTransformer
		]
		
		new Label(mainPanel) => [
			text = "---------------"
		]
		
		new ErrorsPanel(mainPanel, "Por ahora todo bien")
		
		new Label(mainPanel) => [
			text = "Modelo:"
		]
		
		new Label(mainPanel) => [
			value <=> "name"
		]
		
		new Label(mainPanel) => [
			value <=> "phone"
		]
		
		new Label(mainPanel) => [
			value <=> "birthday"
		]
	}
	
	def static void main(String[] args) {
		new PersonWindow(new Person("pepe", 44445555, LocalDate.now)).startApplication
	}
	
}
