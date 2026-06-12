package li.kausch.kmpdemo.kmpbankingapp.service.mock

import li.kausch.kmpdemo.kmpbankingapp.service.AuthService

object MockAuthService : AuthService {
    override suspend fun login(username: String, password: String): Boolean =
        username == "demo" && password == "password"
}
