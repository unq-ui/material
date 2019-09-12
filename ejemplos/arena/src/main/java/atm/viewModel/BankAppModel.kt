package atm.viewModel

import atm.model.Account
import atm.model.AccountCurrent
import atm.model.BankFactory
import atm.model.BankSystem
import org.uqbar.commons.model.annotations.Observable

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
       var listOfAccountAppModel = mutableListOf<AccountAppModel>();
       val mutableIterator = system.accounts.iterator()


       for (e in mutableIterator) {
           listOfAccountAppModel.add(AccountAppModel(e))
       }
       return listOfAccountAppModel;
   }

    fun extract(accountAppModel: AccountAppModel?, mount: Int): Int? {
        selectAccount?.available = selectAccount?.extract(mount)!!
        return selectAccount?.available

    }

}
