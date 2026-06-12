package li.kausch.kmpdemo.kmpbankingapp.business.model

enum class TransactionType { CREDIT, DEBIT }

data class Transaction(
    val id: String,
    val description: String,
    val amount: Double,
    val date: String,
    val type: TransactionType
)
