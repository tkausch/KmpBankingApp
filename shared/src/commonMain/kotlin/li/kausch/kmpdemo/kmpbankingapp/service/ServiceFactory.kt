package li.kausch.kmpdemo.kmpbankingapp.service

object ServiceFactory {
    val authService: AuthService = MockAuthService
    val bankingService: BankingService = MockBankingService
}
