package com.example.sample.dojo.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample.dojo.domain.models.AccountModel
import com.example.sample.dojo.domain.useCases.GetAccountUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getAccountUseCase: GetAccountUseCase
) : ViewModel() {

    val loadingState = mutableStateOf(false)

    val errorState = mutableStateOf<String?>(null)
    var hasError = mutableStateOf(false)

    val accountState = mutableStateOf<AccountModel?>(null)

    fun onLoginClick(account: String) {
        viewModelScope.launch {
            loadingState.value = true

            val result = getAccountUseCase.run(GetAccountUseCase.Params(account))
            if (result.isSuccess) accountState.value = result.getOrNull()
            else {
                errorState.value = result.exceptionOrNull()?.message
            }
            hasError.value = result.isFailure
            loadingState.value = false
        }
    }


}