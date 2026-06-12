package li.kausch.kmpdemo.kmpbankingapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import li.kausch.kmpdemo.kmpbankingapp.business.repository.AccountRepositoryImpl
import li.kausch.kmpdemo.kmpbankingapp.business.repository.AuthRepositoryImpl
import li.kausch.kmpdemo.kmpbankingapp.service.MockAuthService
import li.kausch.kmpdemo.kmpbankingapp.service.MockBankingService
import li.kausch.kmpdemo.kmpbankingapp.ui.BankingScreen
import li.kausch.kmpdemo.kmpbankingapp.ui.LoginScreen

@Composable
@Preview
fun App() {
    val authRepository = AuthRepositoryImpl(MockAuthService)
    val bankingRepository = AccountRepositoryImpl(MockBankingService)
    var isLoggedIn by remember { mutableStateOf(false) }

    MaterialTheme {
        if (isLoggedIn) {
            BankingScreen(bankingRepository)
        } else {
            LoginScreen(authRepository) { isLoggedIn = true }
        }
    }
}
