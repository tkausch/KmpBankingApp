package li.kausch.kmpdemo.kmpbankingapp.business.repository

interface AuthRepository {
    suspend fun login(username: String, password: String): Boolean
}
