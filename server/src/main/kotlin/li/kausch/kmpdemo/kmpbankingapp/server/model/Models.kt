package li.kausch.kmpdemo.kmpbankingapp.server.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(val username: String, val password: String)

@Serializable
data class LoginResponse(val token: String)

@Serializable
data class ErrorResponse(val error: String)

@Serializable
data class AccountResponse(
    val id: String,
    val accountNumber: String,
    val ownerName: String,
    val balance: Double,
    val currency: String
)

@Serializable
data class TransactionResponse(
    val id: String,
    val description: String,
    val amount: Double,
    val date: String,
    val type: String
)
