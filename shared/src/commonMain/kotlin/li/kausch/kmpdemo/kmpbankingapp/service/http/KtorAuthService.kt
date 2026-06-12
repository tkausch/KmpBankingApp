package li.kausch.kmpdemo.kmpbankingapp.service.http

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import li.kausch.kmpdemo.kmpbankingapp.service.AuthService
import li.kausch.kmpdemo.kmpbankingapp.service.model.LoginRequestDTO
import li.kausch.kmpdemo.kmpbankingapp.service.model.LoginResponse

class KtorAuthService(
    private val client: HttpClient,
    private val baseUrl: String
) : AuthService {
    override suspend fun login(username: String, password: String): Boolean {
        val response = client.post("$baseUrl/api/auth/login") {
            contentType(ContentType.Application.Json)
            setBody(LoginRequestDTO(username, password))
        }
        return if (response.status == HttpStatusCode.OK) {
            SessionManager.token = response.body<LoginResponse>().token
            true
        } else {
            false
        }
    }
}
