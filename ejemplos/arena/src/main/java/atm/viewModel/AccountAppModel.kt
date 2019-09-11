package atm.viewModel

import org.uqbar.commons.model.annotations.Observable

@Observable
abstract class AccountAppModel {

    var id : Int = 0
    var available : Int = 0
    abstract fun accountType() : String
    abstract fun extract(monto: Int): Int

}