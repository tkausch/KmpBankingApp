package li.kausch.kmpdemo.kmpbankingapp.business.repository

import li.kausch.kmpdemo.kmpbankingapp.business.model.Account
import li.kausch.kmpdemo.kmpbankingapp.business.model.Transaction
import li.kausch.kmpdemo.kmpbankingapp.business.model.TransactionType
import li.kausch.kmpdemo.kmpbankingapp.service.BankingService

class AccountRepositoryImpl(private val service: BankingService) : AccountRepository {
    override suspend fun getAccount(accountId: String): Account {
        val dto = service.getAccount(accountId)
        return Account(
            id = dto.id,
            accountNumber = dto.accountNumber,
            ownerName = dto.ownerName,
            balance = dto.balance,
            currency = dto.currency
        )
    }

    override suspend fun getTransactions(accountId: String): List<Transaction> =
        service.getTransactions(accountId).map { dto ->
            Transaction(
                id = dto.id,
                description = dto.description,
                amount = dto.amount,
                date = dto.date,
                type = if (dto.type == "CREDIT") TransactionType.CREDIT else TransactionType.DEBIT
            )
        }
}
