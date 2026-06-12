package li.kausch.kmpdemo.kmpbankingapp.server

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import li.kausch.kmpdemo.kmpbankingapp.server.plugins.configureAuthentication
import li.kausch.kmpdemo.kmpbankingapp.server.plugins.configureRouting
import li.kausch.kmpdemo.kmpbankingapp.server.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureAuthentication()
    configureRouting()
}
