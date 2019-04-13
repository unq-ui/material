package atm

class CurrentAccount : Account() {
    var discovered: Int = -20

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

    override fun accountType() = "Cuenta Corriente"
}
