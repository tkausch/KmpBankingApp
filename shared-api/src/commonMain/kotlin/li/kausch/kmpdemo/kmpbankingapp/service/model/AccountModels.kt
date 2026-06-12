package li.kausch.kmpdemo.kmpbankingapp.service.model

import kotlinx.serialization.Serializable

@Serializable
data class AccountDto(
    val id: String,
    val accountNumber: String,
    val ownerName: String,
    val balance: Double,
    val currency: String
)

@Serializable
data class TransactionDto(
    val id: String,
    val description: String,
    val amount: Double,
    val date: String,
    val type: String
)
