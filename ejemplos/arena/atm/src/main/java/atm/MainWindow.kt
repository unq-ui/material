package atm

import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.lacar.ui.model.ControlBuilder


class MainWindow(owner: WindowOwner, model: BankAppModel) : SimpleWindow<BankAppModel>(owner, model) {

    override fun addActions(actionsPanel : Panel) {}

    override fun createFormPanel(mainPanel : Panel) {
        title = "Cajero Automático"

        Label(mainPanel).setText("Seleccione la cuenta con la que desea operar")

        val table = Table<Account>(mainPanel, Account::class.java)
        table.bindItemsToProperty("accounts")
        table.bindValueToProperty<Account, ControlBuilder>("selectAccount")
        Column<Account>(table)
                .setTitle("Tipo de Cuenta")
                .setFixedSize(250)
                .bindContentsToProperty("accountType")

        Column<Account>(table)
                .setTitle("Disponible")
                .setFixedSize(250)
                .bindContentsToProperty("available")

        Label(mainPanel)
                .setText("Ingrese el valor que desea extraer")

        val numericField = TextBox(mainPanel)
        numericField.bindValueToProperty<Int,ControlBuilder>("input")
        numericField.setWidth(12)
        numericField.withFilter { event -> event.potentialTextResult.matches(Regex("[0-9]*")) }

        Button(mainPanel)
                .setCaption("extraer")
                .onClick {
                    val dialog = ConfirmDialog(this, modelObject)
                    dialog.onAccept {
                        selectedAccount()?.extract(amount())
                        cleanData()
                    }
                    dialog.open()
                }

    }

    private fun amount() = modelObject.input
    private fun cleanData() =  modelObject.cleanData()
    private fun selectedAccount() = modelObject.selectAccount
}
