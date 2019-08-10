package geoclaseui

import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*

fun main() = GeoLayoutWindow(GeoModel()).startApplication()

class GeoLayoutWindow(model: GeoModel) : MainWindow<GeoModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Calculador de Distancias"

        mainPanel.asVertical()

        coordinatesPanel(mainPanel, "Desde", "From")
        coordinatesPanel(mainPanel, "Hasta", "To")

        actionsPanel(mainPanel)
        Label(mainPanel) bindTo "result"
    }

    private fun actionsPanel(mainPanel: Panel) {
        Panel(mainPanel) with {
            asHorizontal()
            Button(it) with {
                width = 165
                caption = "Calcular"
                onClick { thisWindow.modelObject.getDistance() }
            }
            Button(it) with {
                width = 165
                caption = "Limpiar"
                onClick { thisWindow.modelObject.getDistance() }
            }
        }
    }

    private fun coordinatesPanel(mainPanel: Panel, subtitle: String, whichCoord: String) {
        Label(mainPanel) with { text = "Coordenadas $subtitle" }

        Panel(mainPanel) with {
            asColumns(2)

            Label(it) with { text = "Latitude" }
            TextBox(it) with {
                width = 150
                bindTo("lat$whichCoord")
            }

            Label(it) with { text = "Longitude" }
            TextBox(it) with {
                width = 150
                bindTo("long$whichCoord")
            }
        }
    }
}
