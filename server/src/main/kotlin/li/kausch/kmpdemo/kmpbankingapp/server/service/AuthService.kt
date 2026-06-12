package li.kausch.kmpdemo.kmpbankingapp.server.service

import li.kausch.kmpdemo.kmpbankingapp.server.auth.JwtConfig
import li.kausch.kmpdemo.kmpbankingapp.service.model.LoginRequestDTO
import li.kausch.kmpdemo.kmpbankingapp.service.model.LoginResponse

object AuthService {
    fun login(request: LoginRequestDTO): LoginResponse? =
        if (request.username == "demo" && request.password == "password")
            LoginResponse(JwtConfig.generateToken(request.username))
        else null
}
