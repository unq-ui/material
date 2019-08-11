package atm

import org.uqbar.commons.model.annotations.Observable

@Observable
abstract class Account {
    var available : Int = 0
    abstract fun extract(amount: Int) : Int
    abstract fun deposit(amount: Int) : Int
    abstract fun accountType() : String
}
