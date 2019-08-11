package conversor.view

import _common.Support
import java.awt.Color
import conversor.model.Conversion
import conversor.model.GenericConverter
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.NumericField
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*

fun main() = GenericConverterWindow(GenericConverter()).startApplication()


/**
 * Conversor genérico que permite diversas operaciones de
 * conversion.
 */
class GenericConverterWindow(model: GenericConverter) : MainWindow<GenericConverter>(model) {
	override fun createContents(mainPanel: Panel) {
		title = "Conversor genérico"
		iconImage = Support.ICON

		mainPanel.asVertical()
		
		ErrorsPanel(mainPanel, "Listo para convertir")

		Label(mainPanel) with { text = "De:" }
		NumericField(mainPanel) bindTo "input"

		List<Conversion>(mainPanel) with {
			allowNull(false)
			bindItemsTo("possibleConversions").adaptWithProp<Conversion>("name")
			bindSelectedTo("conversion")
		}

		Button(mainPanel) with {
			caption = "Convertir"
			onClick { modelObject.convert() }
			bindEnabledTo("hasConversion")
		}
		
		Label(mainPanel) with { text = "A: " }
		Label(mainPanel) with {
			background = Color.ORANGE
			bindTo("output")
		}
	}
}
