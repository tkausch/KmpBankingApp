package li.kausch.kmpdemo.kmpbankingapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import li.kausch.kmpdemo.kmpbankingapp.ui.BankingScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        BankingScreen()
    }
}
