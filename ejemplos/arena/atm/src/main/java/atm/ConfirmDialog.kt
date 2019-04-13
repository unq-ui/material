package atm

import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner


class ConfirmDialog(owner: WindowOwner, model: BankAppModel) : Dialog<BankAppModel>(owner, model) {

    override fun createFormPanel(mainPanel: Panel) {
        Label(mainPanel)
                .setText("Esta seguro que desea extraer $${amount()} de la ${accountType()}")

        Button(mainPanel)
                .setCaption("Aceptar")
                .onClick { accept() }

        Button(mainPanel)
                .setCaption("Cancelar")
                .onClick { cancel() }
    }

    private fun amount() = modelObject.input
    private fun account() = modelObject.selectAccount
    private fun accountType() = account()?.accountType()
}
