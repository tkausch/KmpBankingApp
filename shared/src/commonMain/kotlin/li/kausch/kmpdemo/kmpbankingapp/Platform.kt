package li.kausch.kmpdemo.kmpbankingapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform