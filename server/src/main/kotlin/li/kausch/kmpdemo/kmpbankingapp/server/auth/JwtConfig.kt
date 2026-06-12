package li.kausch.kmpdemo.kmpbankingapp.server.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.util.Date

object JwtConfig {
    const val ISSUER = "kmp-banking"
    const val AUDIENCE = "banking-users"
    const val REALM = "KMP Banking"

    // In production: load from environment variable
    private const val SECRET = "kmp-banking-secret-key-change-in-production"
    private const val EXPIRY_MS = 3_600_000L // 1 hour

    val algorithm: Algorithm = Algorithm.HMAC256(SECRET)

    fun generateToken(username: String): String = JWT.create()
        .withIssuer(ISSUER)
        .withAudience(AUDIENCE)
        .withClaim("username", username)
        .withExpiresAt(Date(System.currentTimeMillis() + EXPIRY_MS))
        .sign(algorithm)
}
