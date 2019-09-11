package atm.model


abstract class Account {
    var id: Int = 0;
    var available : Int = 0
    var accountType : String = ""
    abstract fun extract(amount: Int) : Int
    abstract fun deposit(amount: Int) : Int

}
