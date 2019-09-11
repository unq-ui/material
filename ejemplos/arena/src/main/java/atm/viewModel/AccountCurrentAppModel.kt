package atm.viewModel

import atm.model.Account

 class AccountCurrentAppModel : AccountAppModel{
     var model : Account? = null;

    constructor(accountCurrent : Account){
        this.id = accountCurrent.id
        this.available = accountCurrent.available

        this.model = accountCurrent
    }

    override fun accountType() = "Cuenta Corriente"

    override fun extract(monto: Int): Int {

        return model!!.extract(monto);

    }
}