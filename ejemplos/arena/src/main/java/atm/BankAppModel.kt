package atm

import org.uqbar.commons.model.annotations.Observable

@Observable
class BankAppModel {
   var input = 0
   var accounts = mutableListOf<Account>()
   var selectAccount: Account? = null
   fun cleanData() {
      input = 0
   }
}
