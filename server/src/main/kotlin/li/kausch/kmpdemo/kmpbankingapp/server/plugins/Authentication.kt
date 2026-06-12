package li.kausch.kmpdemo.kmpbankingapp.server.plugins

import com.auth0.jwt.JWT
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import li.kausch.kmpdemo.kmpbankingapp.server.auth.JwtConfig

fun Application.configureAuthentication() {
    install(Authentication) {
        jwt("auth-jwt") {
            realm = JwtConfig.REALM
            verifier(
                JWT.require(JwtConfig.algorithm)
                    .withIssuer(JwtConfig.ISSUER)
                    .withAudience(JwtConfig.AUDIENCE)
                    .build()
            )
            validate { credential ->
                val username = credential.payload.getClaim("username").asString()
                if (username != null) JWTPrincipal(credential.payload) else null
            }
        }
    }
}
