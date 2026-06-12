package li.kausch.kmpdemo.kmpbankingapp.server.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import li.kausch.kmpdemo.kmpbankingapp.server.auth.BearerPrincipal
import li.kausch.kmpdemo.kmpbankingapp.server.auth.TokenStore

fun Application.configureAuthentication() {
    install(Authentication) {
        bearer("auth-bearer") {
            authenticate { credential ->
                if (TokenStore.isValid(credential.token)) BearerPrincipal(credential.token) else null
            }
        }
    }
}
