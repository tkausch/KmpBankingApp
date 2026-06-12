package li.kausch.kmpdemo.kmpbankingapp.service.http

object SessionManager {
    var token: String? = null

    fun clear() { token = null }
}
