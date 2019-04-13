package atm


class SavingBank : Account() {
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

    override fun accountType() = "Caja de ahorro"
}