package unquify

import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.windows.ErrorsPanel

class UnquifyWindow extends MainWindow<UnquifyController> {
	

	new(UnquifyController model) {
		super(model)
	}
	
	override createContents(Panel mainPanel) {
		this.title = "Unquify"
		this.minWidth = 250
		new ErrorsPanel(mainPanel, ""
		)
		new Panel(mainPanel) => [
			
			layout = new HorizontalLayout
			new Label(it) => [
				text = "Filtrar:"
			]
			new TextBox(it) => [
				value <=> "filter"
			]
			new Button(it) => [
				caption = "Crear nuevo"
				onClick[ 
					val newSong = new Song
					new SongInformationWindow(this,newSong) => [
						onAccept[this.modelObject.addSong(newSong)]
						open						
					]
				]
			]
			new Button(it) => [
				caption = "Editar"
				onClick[ 
					new SongInformationWindow(this, modelObject.selectedSong).open
				]
			]
		]
		createSongsTable(mainPanel)
	}
	
	def createSongsTable(Panel mainPanel) {
		val gridSongs = new Table(mainPanel, typeof(Song)) => [
			numberVisibleRows = 5
			items <=> "filteredSongs"
			selection <=> "selectedSong"
		]
		
		new Column<Song>(gridSongs) => [
			title = "Titulo"
			bindContentsToProperty("name")
			fixedSize = 200
		]
		
		new Column<Song>(gridSongs) => [
			title = "Duración"
			fixedSize = 150
			bindContentsToProperty("minDuration")
		]
		
		new Column<Song>(gridSongs) => [
			title = "Banda"
			bindContentsToProperty("band")
			fixedSize = 150
		]
	}
	
	
	def static void main(String[] args) {
		new UnquifyWindow(new UnquifyController(UnquifyFactory.get)).startApplication
	}
	
}