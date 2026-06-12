package li.kausch.kmpdemo.kmpbankingapp.server.auth

import io.ktor.server.auth.*

data class BearerPrincipal(val token: String) : Principal
