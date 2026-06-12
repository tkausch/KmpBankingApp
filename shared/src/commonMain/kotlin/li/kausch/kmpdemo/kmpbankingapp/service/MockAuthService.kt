package li.kausch.kmpdemo.kmpbankingapp.service

object MockAuthService : AuthService {
    override suspend fun login(username: String, password: String): Boolean =
        username == "demo" && password == "password"
}
