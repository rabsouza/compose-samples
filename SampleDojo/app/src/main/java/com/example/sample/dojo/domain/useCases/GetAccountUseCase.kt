package com.example.sample.dojo.domain.useCases

import com.example.sample.dojo.domain.models.AccountModel
import kotlinx.coroutines.delay

class GetAccountUseCase : BaseUseCase<GetAccountUseCase.Params, AccountModel> {

    data class Params(val account: String) : UseCaseParams

    override suspend fun run(params: GetAccountUseCase.Params): Result<AccountModel> {
        delay(100)
        return if (params.account.equals("rabsouza", true))
            Result.success(AccountModel("Rafael", "rabsouza"))
        else
            Result.failure(Exception("Não existe essa conta"))
    }
}