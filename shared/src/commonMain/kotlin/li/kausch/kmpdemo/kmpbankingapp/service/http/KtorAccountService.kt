package li.kausch.kmpdemo.kmpbankingapp.service.http

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.bearerAuth
import li.kausch.kmpdemo.kmpbankingapp.service.AccountService
import li.kausch.kmpdemo.kmpbankingapp.service.model.AccountDto
import li.kausch.kmpdemo.kmpbankingapp.service.model.TransactionDto

class KtorAccountService(
    private val client: HttpClient,
    private val baseUrl: String
) : AccountService {
    override suspend fun getAccount(): AccountDto =
        client.get("$baseUrl/api/account") {
            bearerAuth(SessionManager.token ?: error("Not authenticated"))
        }.body()

    override suspend fun getTransactions(): List<TransactionDto> =
        client.get("$baseUrl/api/account/transactions") {
            bearerAuth(SessionManager.token ?: error("Not authenticated"))
        }.body()
}
