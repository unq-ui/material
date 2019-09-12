package atm.viewModel

import atm.model.Account
import org.uqbar.commons.model.annotations.Observable

@Observable
class AccountAppModel {

    var available : Int = 0
    var model : Account? = null;
    var accountType : String = ""

    constructor(accountCurrent : Account){
        this.available = accountCurrent.available
        this.model = accountCurrent
        this.accountType = accountCurrent.accountType
    }

    fun extract(monto: Int): Int {

        return model!!.extract(monto);

    }

}