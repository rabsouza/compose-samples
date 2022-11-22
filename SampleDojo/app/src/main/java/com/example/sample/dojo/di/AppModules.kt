package com.example.sample.dojo.di

import com.example.sample.dojo.domain.useCases.GetAccountUseCase
import com.example.sample.dojo.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules by lazy { listOf(applicationModule, uiModule, domainModule) }

private val applicationModule = module {

}

private val uiModule = module {
    viewModel { HomeViewModel(get()) }
}

private val domainModule = module {
    factory { GetAccountUseCase() }
}

