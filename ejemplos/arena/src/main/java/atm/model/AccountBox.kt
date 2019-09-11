package atm.model


class AccountBox : Account{

    constructor(){
        this.id = 1
        this.accountType = "CajaDe  Ahorro"
    }

    override fun extract(amount : Int) : Int {
        if (available >= amount) {
            available -= amount
        } else {
            throw NoCreditException("No dispones de saldo suficiente")
        }
        return available
    }

    override fun deposit(amount: Int): Int {
        available -= amount
        return available
    }


}