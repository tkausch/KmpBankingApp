package li.kausch.kmpdemo.kmpbankingapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import li.kausch.kmpdemo.kmpbankingapp.business.model.Account
import li.kausch.kmpdemo.kmpbankingapp.business.model.Transaction
import li.kausch.kmpdemo.kmpbankingapp.business.repository.AccountRepository

sealed class BankingUiState {
    data object Loading : BankingUiState()
    data class Success(val account: Account, val transactions: List<Transaction>) : BankingUiState()
    data class Error(val message: String) : BankingUiState()
}

class BankingViewModel(private val repository: AccountRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<BankingUiState>(BankingUiState.Loading)
    val uiState: StateFlow<BankingUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            try {
                val account = repository.getAccount("acc-001")
                val transactions = repository.getTransactions("acc-001")
                _uiState.value = BankingUiState.Success(account, transactions)
            } catch (e: Exception) {
                _uiState.value = BankingUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
