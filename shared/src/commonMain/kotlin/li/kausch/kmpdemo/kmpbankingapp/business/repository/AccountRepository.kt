package li.kausch.kmpdemo.kmpbankingapp.business.repository

import li.kausch.kmpdemo.kmpbankingapp.business.model.Account
import li.kausch.kmpdemo.kmpbankingapp.business.model.Transaction

interface AccountRepository {
    suspend fun getAccount(accountId: String): Account
    suspend fun getTransactions(accountId: String): List<Transaction>
}
