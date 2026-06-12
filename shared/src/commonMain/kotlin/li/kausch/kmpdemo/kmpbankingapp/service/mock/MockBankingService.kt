package li.kausch.kmpdemo.kmpbankingapp.service.mock

import li.kausch.kmpdemo.kmpbankingapp.service.AccountService
import li.kausch.kmpdemo.kmpbankingapp.service.model.AccountDto
import li.kausch.kmpdemo.kmpbankingapp.service.model.TransactionDto

object MockBankingService : AccountService {
    override suspend fun getAccount(accountId: String) = AccountDto(
        id = "acc-001",
        accountNumber = "DE89 3704 0044 0532 0130 00",
        ownerName = "Thomas Kausch",
        balance = 4250.75,
        currency = "EUR"
    )

    override suspend fun getTransactions(accountId: String) = listOf(
        TransactionDto("t1", "Salary", 3500.00, "2026-06-01", "CREDIT"),
        TransactionDto("t2", "Rent", -1200.00, "2026-06-02", "DEBIT"),
        TransactionDto("t3", "Groceries", -85.50, "2026-06-05", "DEBIT"),
        TransactionDto("t4", "Freelance", 800.00, "2026-06-08", "CREDIT"),
        TransactionDto("t5", "Netflix", -15.99, "2026-06-10", "DEBIT"),
        TransactionDto("t6", "Gym Membership", -49.99, "2026-06-11", "DEBIT"),
        TransactionDto("t7", "Dividend", 302.23, "2026-06-12", "CREDIT"),
    )
}
