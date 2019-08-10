package atm

import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.kotlin.extensions.*


class MainWindow(owner: WindowOwner, model: BankAppModel) : SimpleWindow<BankAppModel>(owner, model) {

    override fun addActions(actionsPanel : Panel) {}

    override fun createFormPanel(mainPanel : Panel) {
        title = "Cajero Automático"

        Label(mainPanel) with { text = "Seleccione la cuenta con la que desea operar" }

        table<Account>(mainPanel) with {
            bindItemsTo("accounts")
            bindSelectionTo("selectAccount")
            column {
                title = "Tipo de Cuenta"
                fixedSize = 250
                bindContentsTo("accountType")
            }
            column {
                title = "Disponible"
                fixedSize = 250
                bindContentsTo("available")
            }
        }

        Label(mainPanel) with { text = "Ingrese el valor que desea extraer" }

        TextBox(mainPanel) with {
            bindTo("input")
            width = 12
            withFilter { event -> event.potentialTextResult.matches(Regex("[0-9]*")) }
        }

        Button(mainPanel) with {
            caption = "extraer"
            onClick {
                ConfirmDialog(thisWindow, modelObject) with {
                    onAccept {
                        selectedAccount()?.extract(amount())
                        cleanData()
                    }
                    open()
                }
            }
        }
    }

    private fun amount() = modelObject.input
    private fun cleanData() =  modelObject.cleanData()
    private fun selectedAccount() = modelObject.selectAccount
}
