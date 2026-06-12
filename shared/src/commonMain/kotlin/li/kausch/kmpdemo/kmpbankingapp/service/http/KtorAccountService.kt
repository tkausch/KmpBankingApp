package li.kausch.kmpdemo.kmpbankingapp.service.http

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import li.kausch.kmpdemo.kmpbankingapp.service.AccountService
import li.kausch.kmpdemo.kmpbankingapp.service.model.AccountDto
import li.kausch.kmpdemo.kmpbankingapp.service.model.TransactionDto

class KtorAccountService(
    client: HttpClient,
    baseUrl: String
) : KtorService(client, baseUrl), AccountService {
    override suspend fun getAccount(): AccountDto =
        client.get("$baseUrl/api/account") { addBearerAuth() }.body()

    override suspend fun getTransactions(): List<TransactionDto> =
        client.get("$baseUrl/api/account/transactions") { addBearerAuth() }.body()
}
