package li.kausch.kmpdemo.kmpbankingapp.server.service

import li.kausch.kmpdemo.kmpbankingapp.server.auth.TokenStore
import li.kausch.kmpdemo.kmpbankingapp.service.model.LoginRequestDTO
import li.kausch.kmpdemo.kmpbankingapp.service.model.LoginResponse

object AuthService {
    fun login(request: LoginRequestDTO): LoginResponse? {
        if (request.username == "demo" && request.password == "password") {
            return LoginResponse(TokenStore.create())
        }
        return null
    }
}
