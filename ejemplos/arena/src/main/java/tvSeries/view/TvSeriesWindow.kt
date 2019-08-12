package tvSeries.view

import _common.Support
import tvSeries.model.ActorAppModel
import tvSeries.model.SerieAppModel
import tvSeries.model.TvSeriesAppModel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.kotlin.extensions.*

class TvSeriesWindow(owner: WindowOwner, model: TvSeriesAppModel)
	: SimpleWindow<TvSeriesAppModel>(owner, model) {
	override fun addActions(actionsPanel: Panel) {}
	override fun createFormPanel(mainPanel: Panel) {}

	override fun createMainTemplate(mainPanel: Panel) {
		title = "TV Series"
		iconImage = Support.ICON

		mainPanel.asHorizontal()
		makeSeriesListPanel(mainPanel)
		makeSelectedSerieEditionPanel(mainPanel)
	}
	
	private fun makeSeriesListPanel(owner: Panel) {
		Panel(owner) with {
			asVertical()
			Label(it) with { text = "Series" }
			List<SerieAppModel>(it) with {
				bindTo("selectedSerie")
				bindItemsTo("series").adaptWithProp<SerieAppModel>("name")
			}
			Button(it) with {
				caption = "Nueva Serie"
				onClick {
					AddSerieDialog(thisWindow, SerieAppModel(null), thisWindow.modelObject).open()
				}
			}
		}
	}

	private fun makeSelectedSerieEditionPanel(owner: Panel) {
		Panel(owner) with { it ->

			Panel(it) with {
				asColumns(2)
				Label(it) with { text = "Nombre:" }
				TextBox(it) with {
					width = 200
					bindTo("selectedSerie.name")
				}

				Label(it) with { text  = "Temporadas:" }
				TextBox(it) with {
					width = 200
					bindTo("selectedSerie.seasons")
				}
			}

			table<ActorAppModel>(it) {
				bindItemsTo("selectedSerie.actors")
				bindTo("selectedActor")
				column {
					title = "Nombre"
					bindContentsTo("name")
				}
				column {
					title = "Personaje"
					bindContentsTo("character")
				}
			}

			Button(it) with {
				caption = "Borrar actor"
				onClick {
					RemoveActorDialog(thisWindow, thisWindow.modelObject.selectedActor) with {
						onAccept { removeSelectedActor() }
						open()
					}
				}
			}
		}
	}

	private fun removeSelectedActor() = modelObject.removeSelectedActor()
}
