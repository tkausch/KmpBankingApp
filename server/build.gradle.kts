plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.kotlinxSerialization)
    application
}

group = "li.kausch.kmpdemo.kmpbankingapp"
version = "1.0.0"

application {
    mainClass.set("li.kausch.kmpdemo.kmpbankingapp.server.ApplicationKt")
}

dependencies {
    implementation(projects.sharedApi)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.call.logging)
    implementation(libs.logback.classic)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test)
}
