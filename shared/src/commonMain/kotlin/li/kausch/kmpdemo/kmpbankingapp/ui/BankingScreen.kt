package li.kausch.kmpdemo.kmpbankingapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import li.kausch.kmpdemo.kmpbankingapp.business.model.Account
import li.kausch.kmpdemo.kmpbankingapp.business.model.Transaction
import li.kausch.kmpdemo.kmpbankingapp.business.model.TransactionType
import li.kausch.kmpdemo.kmpbankingapp.business.repository.AccountRepositoryImpl
import li.kausch.kmpdemo.kmpbankingapp.service.MockBankingService

@Composable
fun BankingScreen() {
    val viewModel = viewModel { BankingViewModel(AccountRepositoryImpl(MockBankingService())) }
    val uiState by viewModel.uiState.collectAsState()

    when (val state = uiState) {
        is BankingUiState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        is BankingUiState.Error -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Error: ${state.message}", color = MaterialTheme.colorScheme.error)
        }
        is BankingUiState.Success -> BankingContent(
            account = state.account,
            transactions = state.transactions
        )
    }
}

@Composable
private fun BankingContent(account: Account, transactions: List<Transaction>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { Spacer(Modifier.height(8.dp)) }
        item { AccountCard(account) }
        item {
            Text(
                "Transactions",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        items(transactions, key = { it.id }) { transaction ->
            TransactionItem(transaction)
        }
        item { Spacer(Modifier.height(8.dp)) }
    }
}

@Composable
private fun AccountCard(account: Account) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(account.ownerName, style = MaterialTheme.typography.titleMedium)
            Text(
                account.accountNumber,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
            )
            Spacer(Modifier.height(16.dp))
            Text(
                "${account.currency} ${formatAmount(account.balance)}",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Current Balance",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
private fun TransactionItem(transaction: Transaction) {
    val isCredit = transaction.type == TransactionType.CREDIT
    val amountColor = if (isCredit) Color(0xFF2E7D32) else Color(0xFFC62828)
    val amountText = if (isCredit) "+${formatAmount(transaction.amount)}" else "-${formatAmount(transaction.amount)}"

    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(transaction.description, style = MaterialTheme.typography.bodyLarge)
                Text(
                    transaction.date,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
            Text(
                amountText,
                color = amountColor,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

private fun formatAmount(amount: Double): String =
    "%.2f".format(if (amount < 0) -amount else amount)
