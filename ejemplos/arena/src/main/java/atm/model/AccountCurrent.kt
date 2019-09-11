package atm.model

class AccountCurrent : Account{

    var discovered: Int = -20

    constructor(){
        this.id = 2
        this.accountType = "CuentaCorriente"
    }

    override fun extract(amount: Int): Int {
        if (available >= discovered + amount) {
            available -= amount
        } else {
            throw NoCreditException("No puedes superar el descubierto")
        }
        return available
    }

    override fun deposit(amount: Int): Int {
        available += amount
        return available
    }


}
