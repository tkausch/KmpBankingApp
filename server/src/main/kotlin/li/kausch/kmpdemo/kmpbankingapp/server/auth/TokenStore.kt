package li.kausch.kmpdemo.kmpbankingapp.server.auth

import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

object TokenStore {
    private val tokens = ConcurrentHashMap<String, String>() // token → username

    fun create(username: String): String =
        UUID.randomUUID().toString().also { tokens[it] = username }

    fun getUsername(token: String): String? = tokens[token]
    fun isValid(token: String): Boolean = token in tokens
    fun revoke(token: String) { tokens.remove(token) }
}
