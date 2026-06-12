package li.kausch.kmpdemo.kmpbankingapp.business.repository

import li.kausch.kmpdemo.kmpbankingapp.business.model.Account
import li.kausch.kmpdemo.kmpbankingapp.business.model.Transaction
import li.kausch.kmpdemo.kmpbankingapp.business.model.TransactionType
import li.kausch.kmpdemo.kmpbankingapp.service.AccountService

class AccountRepositoryImpl(private val service: AccountService) : AccountRepository {
    override suspend fun getAccount(): Account {
        val dto = service.getAccount()
        return Account(
            id = dto.id,
            accountNumber = dto.accountNumber,
            ownerName = dto.ownerName,
            balance = dto.balance,
            currency = dto.currency
        )
    }

    override suspend fun getTransactions(): List<Transaction> =
        service.getTransactions().map { dto ->
            Transaction(
                id = dto.id,
                description = dto.description,
                amount = dto.amount,
                date = dto.date,
                type = if (dto.type == "CREDIT") TransactionType.CREDIT else TransactionType.DEBIT
            )
        }
}
