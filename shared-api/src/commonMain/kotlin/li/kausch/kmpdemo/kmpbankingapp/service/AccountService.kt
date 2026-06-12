package li.kausch.kmpdemo.kmpbankingapp.service

import li.kausch.kmpdemo.kmpbankingapp.service.model.AccountDto
import li.kausch.kmpdemo.kmpbankingapp.service.model.TransactionDto

interface AccountService {
    suspend fun getAccount(accountId: String): AccountDto
    suspend fun getTransactions(accountId: String): List<TransactionDto>
}
