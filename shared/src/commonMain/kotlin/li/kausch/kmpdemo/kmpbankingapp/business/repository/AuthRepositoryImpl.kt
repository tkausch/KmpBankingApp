package li.kausch.kmpdemo.kmpbankingapp.business.repository

import li.kausch.kmpdemo.kmpbankingapp.service.AuthService

class AuthRepositoryImpl(private val service: AuthService) : AuthRepository {
    override suspend fun login(username: String, password: String): Boolean =
        service.login(username, password)
}
