package li.kausch.kmpdemo.kmpbankingapp.server.routing

import io.ktor.server.response.*
import io.ktor.server.routing.*
import li.kausch.kmpdemo.kmpbankingapp.server.service.AccountService

fun Route.accountRoutes() {
    get("/account") {
        call.respond(AccountService.getAccount())
    }
    get("/account/transactions") {
        call.respond(AccountService.getTransactions())
    }
}
