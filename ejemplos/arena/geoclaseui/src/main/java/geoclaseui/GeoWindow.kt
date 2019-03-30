package geoclaseui

import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
import org.uqbar.lacar.ui.model.ControlBuilder

class GeoWindow(model: GeoModel) : MainWindow<GeoModel>(model) {

    override fun createContents(panel: Panel) {
        title = "Calculador de Distancias"

        Label(panel)
                .setText("Coordenadas Desde")
                .alignLeft()
        TextBox(panel)
                .bindValueToProperty<Int, ControlBuilder>("lat1")
        TextBox(panel)
                .bindValueToProperty<Double, ControlBuilder>("long1")

        Label(panel)
                .setText("Coordenadas Para")
                .alignLeft()
        TextBox(panel)
                .bindValueToProperty<Double, ControlBuilder>("lat2")
        TextBox(panel)
                .bindValueToProperty<Double, ControlBuilder>("long2")

        Button(panel)
                .setCaption("Calcular Distancia")
                .onClick { calculate() }
        Label(panel)
                .bindValueToProperty<String, ControlBuilder>("result")
    }

    private fun calculate() {
        modelObject.getDistance()
    }
}
