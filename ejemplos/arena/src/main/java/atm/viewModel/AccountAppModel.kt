package atm.viewModel

import atm.model.Account
import org.uqbar.commons.model.annotations.Observable

@Observable
class AccountAppModel {

    var available : Int = 0
    var model : Account? = null;

    constructor(accountCurrent : Account){
        this.available = accountCurrent.available
        this.model = accountCurrent
    }

    fun accountType() = "Cuenta Corriente"

    fun extract(monto: Int): Int {

        return model!!.extract(monto);

    }

}