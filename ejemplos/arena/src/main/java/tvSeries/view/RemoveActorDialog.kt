package tvSeries.view

import tvSeries.model.ActorAppModel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.kotlin.extensions.*

class RemoveActorDialog(owner: WindowOwner, model: ActorAppModel?) : Dialog<ActorAppModel>(owner, model) {
	override fun createFormPanel(mainPanel: Panel) {
		title = "Borrar Actor"
		mainPanel.asVertical()
		
		Label(mainPanel) with {
			text = "Está a punto de quitar a ${modelObject.name} (${modelObject.character}) " +
					"de ${modelObject.serie?.name}.\n" +
					"¿Está seguro?"
		}

		Panel(mainPanel) with {
			asHorizontal()
			Button(it) with {
				caption = "Cancelar"
				onClick { cancel() }
			}
			Button(it) with {
				caption = "Aceptar"
				onClick { accept() }
			}
		}
	}
}
