package li.kausch.kmpdemo.kmpbankingapp.server.routing

import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import li.kausch.kmpdemo.kmpbankingapp.server.service.AccountService

fun Route.accountRoutes() {
    get("/account") {
        val username = call.principal<JWTPrincipal>()!!.payload.getClaim("username").asString()
        call.respond(AccountService.getAccount(username))
    }
    get("/account/transactions") {
        val username = call.principal<JWTPrincipal>()!!.payload.getClaim("username").asString()
        call.respond(AccountService.getTransactions(username))
    }
}
