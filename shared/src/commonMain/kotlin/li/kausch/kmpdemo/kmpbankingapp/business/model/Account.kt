package li.kausch.kmpdemo.kmpbankingapp.business.model

data class Account(
    val id: String,
    val accountNumber: String,
    val ownerName: String,
    val balance: Double,
    val currency: String
)
