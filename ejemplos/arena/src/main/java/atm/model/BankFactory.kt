package atm.model


object BankFactory {

    private val bankSystem = BankSystem()
    init {
        bankSystem.addAccount(BankFactory.makeCurrentAccount())
        bankSystem.addAccount(BankFactory.makeAccountBox())

    }

    fun makeBankSystem() = bankSystem

    private fun makeCurrentAccount(): Account {
        var currentAccount = AccountCurrent();
        currentAccount.available = 100

         return currentAccount
    }

    private fun makeAccountBox(): Account {
        var currentBox = AccountBox();
        currentBox.available = 30

        return currentBox
    }

}