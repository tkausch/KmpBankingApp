package li.kausch.kmpdemo.kmpbankingapp.service

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import li.kausch.kmpdemo.kmpbankingapp.service.http.KtorAccountService
import li.kausch.kmpdemo.kmpbankingapp.service.http.KtorAuthService

object ServiceFactory {
    // Android emulator: http://10.0.2.2:8080 — iOS simulator: http://localhost:8080
    private const val BASE_URL = "http://localhost:8080"

    private val httpClient = HttpClient {
        install(ContentNegotiation) { json() }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
        }
    }

    val authService: AuthService = KtorAuthService(httpClient, BASE_URL)
    val bankingService: AccountService = KtorAccountService(httpClient, BASE_URL)
}
