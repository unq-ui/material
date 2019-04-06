package geoclaseui

import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
import org.uqbar.lacar.ui.model.ControlBuilder

class GeoLayoutWindow(model: GeoModel) : MainWindow<GeoModel>(model) {

    override fun createContents(mainPanel: Panel) {
        title = "Calculador de Distancias"

        // no hace falta, es del de por defecto
        mainPanel.setLayout(VerticalLayout())

        coordinatesPanel(mainPanel, "Desde", "From")
        coordinatesPanel(mainPanel, "Hasta", "To")

        actionsPanel(mainPanel)

        resultPanel(mainPanel)
    }

    private fun resultPanel(mainPanel: Panel) {
        Label(mainPanel)
                .bindValueToProperty<String, ControlBuilder>("result")
    }

    private fun actionsPanel(mainPanel: Panel) {
        val hPanelButtons = Panel(mainPanel)
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

    private fun coordinatesPanel(mainPanel: Panel, subtitle: String, whichCoord: String) {
        Label(mainPanel).setText("Coordenadas $subtitle")
        val columnPanel = Panel(mainPanel).setLayout(ColumnLayout(2))
        Label(columnPanel).setText("Latitude")
        TextBox(columnPanel)
                .setWidth(150)
                .bindValueToProperty<Int, ControlBuilder>("lat$whichCoord")

        Label(columnPanel).setText("Longitude")
        TextBox(columnPanel)
                .setWidth(150)
                .bindValueToProperty<Double, ControlBuilder>("long$whichCoord")
    }

    private fun calculate() = modelObject.getDistance()
    private fun clean() = modelObject.cleanData()
}
