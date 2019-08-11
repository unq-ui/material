package conversorUI

import java.awt.Color
import conversor.BasicConverter
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.NumericField
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*

fun main() = ConversorWindow(BasicConverter()).startApplication()

class ConversorWindow(model: BasicConverter) : MainWindow<BasicConverter>(model) {

    override fun createContents(mainPanel: Panel) {
        title = "Conversor de millas a kilómetros"

        mainPanel.asVertical()
        ErrorsPanel(mainPanel, "Listo para convertir")

        Label(mainPanel) with { text = "Ingrese la longitud en millas" }
        NumericField(mainPanel) bindTo "miles"

        Button(mainPanel) with {
            caption = "Convertir a kilómetros"
            onClick { modelObject.convert() }
        }

        Label(mainPanel) with {
            background = Color.ORANGE
            bindTo("kilometers")
        }

        Label(mainPanel) with { text = " kilómetros" }
    }
}
