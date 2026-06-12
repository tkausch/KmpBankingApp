package li.kausch.kmpdemo.kmpbankingapp.server.routing

import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import li.kausch.kmpdemo.kmpbankingapp.server.auth.TokenStore
import li.kausch.kmpdemo.kmpbankingapp.server.model.ErrorResponse
import li.kausch.kmpdemo.kmpbankingapp.server.model.LoginRequest
import li.kausch.kmpdemo.kmpbankingapp.server.model.LoginResponse

fun Route.authRoutes() {
    post("/auth/login") {
        val request = call.receive<LoginRequest>()
        if (request.username == "demo" && request.password == "password") {
            call.respond(HttpStatusCode.OK, LoginResponse(TokenStore.create()))
        } else {
            call.respond(HttpStatusCode.Unauthorized, ErrorResponse("Invalid username or password"))
        }
    }
}
