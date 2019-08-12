package unquify

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.kotlin.extensions.*

fun main() = UnquifyWindow(UnquifyController(UnquifyFactory.get())).startApplication()

class UnquifyWindow(model: UnquifyController) : MainWindow<UnquifyController>(model) {
	override fun createContents(mainPanel: Panel) {
		title = "Unquify"
		setMinWidth(250)
		ErrorsPanel(mainPanel, "")
		Panel(mainPanel) with {
			asHorizontal()
			Label(it) with { text = "Filtrar:" }
			TextBox(it) bindTo "filter"
			Button(it) with {
				caption = "Crear nuevo"
				onClick {
					val newSong = Song()
					SongInformationWindow(thisWindow, newSong) with {
						onAccept { addSong(newSong) }
						open()
					}
				}
			}
			Button(it) with {
				caption = "Editar"
				onClick {
					SongInformationWindow(thisWindow, thisWindow.modelObject.selectedSong).open()
				}
			}
		}
		createSongsTable(mainPanel)
	}
	
	private fun createSongsTable(mainPanel: Panel) {
		table<Song>(mainPanel) with {
			visibleRows = 5
			bindItemsTo("filteredSongs")
			bindSelectionTo("selectedSong")
			column {
				title = "Titulo"
				fixedSize = 200
				bindContentsTo("name")
			}
			column {
				title = "Duración"
				fixedSize = 150
				bindContentsTo("minDuration")
			}
			column {
				title = "Banda"
				fixedSize = 150
				bindContentsTo("band")
			}
		}
	}

	private fun addSong(song: Song) = modelObject.addSong(song)
}
