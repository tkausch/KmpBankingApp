package li.kausch.kmpdemo.kmpbankingapp.service.model

data class TransactionDto(
    val id: String,
    val description: String,
    val amount: Double,
    val date: String,
    val type: String
)
