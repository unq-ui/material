package unquify

import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.aop.windows.TransactionalDialog

class SongInformationWindow extends TransactionalDialog<Song> {
	
	new(WindowOwner owner, Song model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		
		new Panel(mainPanel) => [
			layout = new HorizontalLayout
			new Label(it) => [
				text = "Nombre:"
			]
			new TextBox(it) => [
				value <=> "name"
			]
		]
		new Panel(mainPanel) => [
			layout = new HorizontalLayout
			new Label(it) => [
				text = "Duración:"
			]
			new TextBox(it) => [
				withFilter(new DurationFilter)
				(value <=> "duration").transformer = new DurationTransformer
			]
		]
		new Panel(mainPanel) => [
			layout = new HorizontalLayout
			new Label(it) => [
				text = "Banda:"
			]
			new TextBox(it) => [
				value <=> "band"
			]
		]
		
		new Button(mainPanel) => [
			caption = "Aceptar"
			onClick[ this.accept() ]
		]
	}
		
}