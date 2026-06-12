package li.kausch.kmpdemo.kmpbankingapp.server.auth

import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

object TokenStore {
    private val tokens = ConcurrentHashMap.newKeySet<String>()

    fun create(): String = UUID.randomUUID().toString().also { tokens.add(it) }
    fun isValid(token: String): Boolean = token in tokens
    fun revoke(token: String) { tokens.remove(token) }
}
