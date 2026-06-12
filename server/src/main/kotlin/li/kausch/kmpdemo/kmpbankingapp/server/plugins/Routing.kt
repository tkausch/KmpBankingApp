package li.kausch.kmpdemo.kmpbankingapp.server.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*
import li.kausch.kmpdemo.kmpbankingapp.server.routing.accountRoutes
import li.kausch.kmpdemo.kmpbankingapp.server.routing.authRoutes

fun Application.configureRouting() {
    routing {
        route("/api") {
            authRoutes()
            authenticate("auth-jwt") {
                accountRoutes()
            }
        }
    }
}
