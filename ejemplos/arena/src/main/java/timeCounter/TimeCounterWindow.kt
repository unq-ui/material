package timeCounter

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*

fun main() = TimeCounterWindow(TimeCounter()).startApplication()

class TimeCounterWindow(model: TimeCounter) : MainWindow<TimeCounter>(model) {
	override fun createContents(mainPanel: Panel) {
		title = "Cantidad de Días"
		setMinWidth(250)
		
		Panel(mainPanel) with {
			asHorizontal()
			Label(it) with { text = "Hoy es:" }
			Label(it) bindTo "now"
		}
		
		Panel(mainPanel) with {
			asHorizontal()
			Label(it) with { text = "Fecha:" }
			TextBox(it) with {
				withFilter(LocalDateFilter())
				bindTo("anotherDate").setTransformer(LocalDateTransformer())
			}
		}
		
		Label(mainPanel) with { text = "_______Modelo_______" }
		Panel(mainPanel) with {
			asHorizontal()
			Label(it) with { text = "AnotherDate:" }
			Label(it) bindTo "anotherDate"
		}
	}
}
