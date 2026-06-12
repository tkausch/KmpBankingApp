package li.kausch.kmpdemo.kmpbankingapp.service

import li.kausch.kmpdemo.kmpbankingapp.service.mock.MockAuthService
import li.kausch.kmpdemo.kmpbankingapp.service.mock.MockBankingService

object ServiceFactory {
    val authService: AuthService = MockAuthService
    val bankingService: AccountService = MockBankingService
}
