package li.kausch.kmpdemo.kmpbankingapp.server.routing

import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import li.kausch.kmpdemo.kmpbankingapp.server.auth.BearerPrincipal
import li.kausch.kmpdemo.kmpbankingapp.server.service.AccountService

fun Route.accountRoutes() {
    get("/account") {
        val token = call.principal<BearerPrincipal>()!!.token
        call.respond(AccountService.getAccount(token))
    }
    get("/account/transactions") {
        val token = call.principal<BearerPrincipal>()!!.token
        call.respond(AccountService.getTransactions(token))
    }
}
