package li.kausch.kmpdemo.kmpbankingapp.business.repository

import li.kausch.kmpdemo.kmpbankingapp.business.model.Account
import li.kausch.kmpdemo.kmpbankingapp.business.model.Transaction

interface AccountRepository {
    suspend fun getAccount(): Account
    suspend fun getTransactions(): List<Transaction>
}
