package conversor.view

import _common.Support
import conversor.model.SynchronizedConverter
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*

fun main() = SynchronizedConverterWindow(SynchronizedConverter()).startApplication()

/**
 * Variante del conversor bidireccional.
 * Es decir que permite convertir millas a km pero también de km a millas.
 * Para esto, no utiliza ningún botón, sino que convierte instantáneamente a medida que se
 * va ingresando el valor en uno de los dos textFields.
 */
class SynchronizedConverterWindow(model: SynchronizedConverter) : MainWindow<SynchronizedConverter>(model) {
	override fun createContents(mainPanel: Panel) {
		title = "Conversor sincronizado"
		iconImage = Support.ICON

		mainPanel.asVertical()
		
		ErrorsPanel(mainPanel, "Listo para convertir")

		Label(mainPanel) with { text = "Millas:" }
		TextBox(mainPanel) bindTo "miles"
		
		Label(mainPanel) with { text = "Kilometros:" }
		TextBox(mainPanel) bindTo "kilometers"
	}
}
