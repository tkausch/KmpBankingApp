package li.kausch.kmpdemo.kmpbankingapp.server.routing

import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import li.kausch.kmpdemo.kmpbankingapp.server.service.AuthService
import li.kausch.kmpdemo.kmpbankingapp.service.model.ErrorResponse
import li.kausch.kmpdemo.kmpbankingapp.service.model.LoginRequestDTO
import li.kausch.kmpdemo.kmpbankingapp.service.model.LoginResponse

fun Route.authRoutes() {
    post("/auth/login") {
        val request = call.receive<LoginRequestDTO>()
        val token = AuthService.login(request.username, request.password)
        if (token != null) {
            call.respond(HttpStatusCode.OK, LoginResponse(token))
        } else {
            call.respond(HttpStatusCode.Unauthorized, ErrorResponse("Invalid username or password"))
        }
    }
}
