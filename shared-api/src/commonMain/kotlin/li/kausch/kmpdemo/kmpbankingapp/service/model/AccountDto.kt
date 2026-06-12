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
