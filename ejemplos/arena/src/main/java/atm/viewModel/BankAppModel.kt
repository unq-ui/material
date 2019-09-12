package atm.viewModel

import atm.model.Account
import atm.model.AccountCurrent
import atm.model.BankFactory
import atm.model.BankSystem
import org.uqbar.commons.model.annotations.Observable
import tvSeries.model.SerieAppModel

@Observable
class BankAppModel {
   var input = 0
   private val system: BankSystem = BankFactory.makeBankSystem()
   var accounts : MutableList<AccountAppModel> = initAccounts();
   var selectAccount: AccountAppModel ? = null
   fun cleanData() {
      input = 0
   }



   private fun initAccounts(): MutableList<AccountAppModel> {
       
       return system.accounts.map { AccountAppModel(it) }.toMutableList()

   }

    fun extract(accountAppModel: AccountAppModel?, mount: Int): Int? {
        selectAccount?.available = selectAccount?.extract(mount)!!
        return selectAccount?.available

    }

}
