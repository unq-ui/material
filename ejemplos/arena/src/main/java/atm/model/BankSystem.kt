package atm.model

class BankSystem {

    val accounts = mutableListOf<Account>()

    fun addAccount(account: Account?) {
        if (account == null) return
        accounts.add(account)
    }




}