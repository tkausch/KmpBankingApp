package li.kausch.kmpdemo.kmpbankingapp.service.http

import io.ktor.client.*
import io.ktor.client.request.*

abstract class KtorService(
    protected val client: HttpClient,
    protected val baseUrl: String
) {
    protected fun HttpRequestBuilder.addBearerAuth() {
        bearerAuth(SessionManager.token ?: error("Not authenticated"))
    }
}
