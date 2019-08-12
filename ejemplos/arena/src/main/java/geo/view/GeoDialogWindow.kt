package geo.view

import _common.Support
import geo.model.GeoModel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.kotlin.extensions.*

fun main() = GeoDialogWindow(GeoModel()).startApplication()

/**
 * Main Window
 */
class GeoDialogWindow(model: GeoModel) : MainWindow<GeoModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Calculador de Distancias"
        iconImage = Support.ICON

        mainPanel.asVertical()

        Label(mainPanel) with { text = "Coordenadas Desde" }
        Panel(mainPanel) with {
            asColumns(2)
            labeledCoordinate(it, "Latitude", "latFrom")
            labeledCoordinate(it, "Longitude", "longFrom")
        }

        Label(mainPanel) with { text = "Coordenadas Hasta" }
        Panel(mainPanel) with {
            asColumns(2)
            labeledCoordinate(it, "Latitude", "latTo")
            labeledCoordinate(it, "Longitude", "longTo")
        }

        Panel(mainPanel) with {
            asHorizontal()
            Button(it) with {
                width = 165
                caption = "Calcular"
                onClick { calculate() }
            }
            Button(it) with {
                width = 165
                caption = "Limpiar"
                onClick { clean() }
            }

        }
    }

    private fun labeledCoordinate(panel: Panel, name: String, bindProp: String) {
        Label(panel) with { text = name }
        TextBox(panel) with {
            width = 150
            bindTo(bindProp)
        }
    }

    private fun calculate() {
        modelObject.getDistance()
        GeoCalculateDialog(thisWindow, modelObject) with {
            onAccept { clean() }
            open()
        }
    }
    private fun clean() = modelObject.cleanData()
}

/**
 * Dialog
 */
class GeoCalculateDialog(owner: WindowOwner, model: GeoModel) : Dialog<GeoModel>(owner, model) {
    override fun createFormPanel(mainPanel: Panel) {
        title = "Resultado de Distancia"

        Label(mainPanel) bindTo "result"

        Button(mainPanel) with {
            caption = "Cerrar y Limpiar"
            onClick { accept() }
        }

        Button(mainPanel) with {
            caption = "Cerrar"
            onClick { cancel() }
        }
    }
}
