package atm.view

import atm.viewModel.BankAppModel
import atm.model.AccountCurrent
import atm.model.AccountBox
import org.uqbar.arena.Application

// Start Application
fun main() = MainApplication().start()

class MainApplication : Application() {

    override fun createMainWindow(): MainWindow {


        return MainWindow(this, BankAppModel())
    }
}
