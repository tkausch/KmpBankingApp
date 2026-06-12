package li.kausch.kmpdemo.kmpbankingapp.service

interface AuthService {
    suspend fun login(username: String, password: String): Boolean
}
