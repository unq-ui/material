package unquify

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.aop.windows.TransactionalDialog
import org.uqbar.arena.kotlin.extensions.*

class SongInformationWindow(owner: WindowOwner, model: Song?) : TransactionalDialog<Song>(owner, model) {
	override fun createFormPanel(mainPanel: Panel) {
		Panel(mainPanel) with {
			asHorizontal()
			Label(it) with { text = "Nombre:" }
			TextBox(it) bindTo "name"
		}
		Panel(mainPanel) with {
			asHorizontal()
			Label(it) with { text = "Duración:" }
			TextBox(it) with {
				withFilter(DurationFilter())
				bindTo("duration").setTransformer(DurationTransformer())
			}
		}
		Panel(mainPanel) with {
			asHorizontal()
			Label(it) with { text = "Banda:" }
			TextBox(it) bindTo "band"
		}
		
		Button(mainPanel) with {
			caption = "Aceptar"
			onClick { accept() }
		}
	}
}
