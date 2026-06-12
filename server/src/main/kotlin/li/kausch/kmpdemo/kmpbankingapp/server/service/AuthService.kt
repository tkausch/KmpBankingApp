package li.kausch.kmpdemo.kmpbankingapp.server.service

import li.kausch.kmpdemo.kmpbankingapp.server.auth.TokenStore

object AuthService {
    fun login(username: String, password: String): String? {
        if (username == "demo" && password == "password") {
            return TokenStore.create()
        }
        return null
    }
}
