package geoclaseui

import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.lacar.ui.model.ControlBuilder

class GeoDialogWindow(model: GeoModel) : MainWindow<GeoModel>(model) {

    override fun createContents(mainPanel: Panel) {
        title = "Calculador de Distancias"

        mainPanel.setLayout(VerticalLayout()) // no hace falta, es el comportamiento por default

        coordinatesPanel(mainPanel, mapOf(
                "title" to "Coordenadas Desde",
                "bindLat" to "latFrom",
                "bindLong" to "longFrom"
        ))
        coordinatesPanel(mainPanel, mapOf(
                "title" to "Coordenadas Hasta",
                "bindLat" to "latTo",
                "bindLong" to "longTo"
        ))

        actionsPanel(mainPanel)
    }

    private fun actionsPanel(parentPanel: Panel) {
        val hPanelButtons = Panel(parentPanel)
                .setLayout(HorizontalLayout())
        Button(hPanelButtons)
                .setCaption("Calcular")
                .onClick { calculate() }
                .setWidth(165)
        Button(hPanelButtons)
                .setCaption("Limpiar")
                .onClick { clean() }
                .setWidth(165)
    }

    private fun coordinatesPanel(parentPanel: Panel, data: Map<String, String>) {
        Label(parentPanel).setText(data["title"])

        val columnPanel = Panel(parentPanel).setLayout(ColumnLayout(2))
        labeledCoordinate(columnPanel, "Latitude", data["bindLat"])
        labeledCoordinate(columnPanel, "Longitude", data["bindLong"])
    }

    private fun labeledCoordinate(panel: Panel, name: String, bindProp: String?) {
        Label(panel).setText(name)
        TextBox(panel)
                .setWidth(150)
                .bindValueToProperty<Int, ControlBuilder>(bindProp)
    }

    private fun calculate() {
        modelObject.getDistance()
        val dialog = GeoCalculateDialog(this, modelObject)
        dialog.onAccept { clean() }
        dialog.open()
    }
    private fun clean() = modelObject.cleanData()
}

class GeoCalculateDialog(owner: WindowOwner, model: GeoModel) : Dialog<GeoModel>(owner, model) {

    override fun createFormPanel(mainPanel: Panel) {
        title = "Resultado de Distancia"

        Label(mainPanel)
                .bindValueToProperty<String, ControlBuilder>("result")
        Button(mainPanel)
                .setCaption("Cerrar y Limpiar")
                .onClick { accept() }
        Button(mainPanel)
                .setCaption("Cerrar")
                .onClick { cancel() }
    }

}

