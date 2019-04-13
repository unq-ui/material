package atm

import org.uqbar.arena.Application

// Start Application
fun main() = MainApplication().start()

class MainApplication : Application() {

    override fun createMainWindow(): MainWindow {
        val currentAccount = CurrentAccount()
        currentAccount.available = 100

        val savingBank = SavingBank()
        savingBank.available = 10

        val bank = BankAppModel()
        bank.accounts.add(currentAccount)
        bank.accounts.add(savingBank)

        return MainWindow(this, bank)
    }
}
