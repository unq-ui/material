package tvSeries.view

import tvSeries.model.SerieAppModel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.kotlin.extensions.*
import tvSeries.model.TvSeriesAppModel

class AddSerieDialog(owner: WindowOwner, model: SerieAppModel, private val system: TvSeriesAppModel)
	: Dialog<SerieAppModel>(owner, model) {
	override fun createFormPanel(mainPanel: Panel) {
		title = "Nueva Serie"
		mainPanel.asVertical()
		
		Label(mainPanel) with { text = "Nombre:" }
		TextBox(mainPanel) with {
			width = 200
			bindTo("name")
		}

		Label(mainPanel) with { text = "Temporadas:" }
		TextBox(mainPanel) with {
			width = 200
			bindTo("seasons")
		}

		Button(mainPanel) with {
			caption = "Aceptar"
			onClick {
				modelObject.createSerie()
				system.addNewSerie(modelObject)
				accept()
			}
		}
	}
	
}