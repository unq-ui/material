package geoclaseui

import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.kotlin.extensions.*

fun main() = GeoWindow(GeoModel()).startApplication()

class GeoWindow(model: GeoModel) : MainWindow<GeoModel>(model) {

    override fun createContents(panel: Panel) {
        title = "Calculador de Distancias"

        Label(panel) with {
            text = "Coordenadas Desde"
            align = "left"
        }

        TextBox(panel) bindTo "latFrom"
        TextBox(panel) bindTo "longFrom"

        Label(panel) with {
            text = "Coordenadas Para"
            align = "left"
        }

        TextBox(panel) bindTo "latTo"
        TextBox(panel) bindTo "longTo"

        Button(panel) with {
            caption = "Calcular Distancia"
            onClick { modelObject.getDistance() }
        }

        Label(panel) bindTo "result"
    }
}
