package li.kausch.kmpdemo.kmpbankingapp.server.service

import li.kausch.kmpdemo.kmpbankingapp.server.model.AccountResponse
import li.kausch.kmpdemo.kmpbankingapp.server.model.TransactionResponse

object AccountService {
    fun getAccount() = AccountResponse(
        id = "acc-001",
        accountNumber = "DE89 3704 0044 0532 0130 00",
        ownerName = "Thomas Kausch",
        balance = 4250.75,
        currency = "EUR"
    )

    fun getTransactions() = listOf(
        TransactionResponse("t1", "Salary", 3500.00, "2026-06-01", "CREDIT"),
        TransactionResponse("t2", "Rent", -1200.00, "2026-06-02", "DEBIT"),
        TransactionResponse("t3", "Groceries", -85.50, "2026-06-05", "DEBIT"),
        TransactionResponse("t4", "Freelance", 800.00, "2026-06-08", "CREDIT"),
        TransactionResponse("t5", "Netflix", -15.99, "2026-06-10", "DEBIT"),
        TransactionResponse("t6", "Gym Membership", -49.99, "2026-06-11", "DEBIT"),
        TransactionResponse("t7", "Dividend", 302.23, "2026-06-12", "CREDIT"),
    )
}
