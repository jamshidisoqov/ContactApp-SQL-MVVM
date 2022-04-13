package com.example.contactappsql.di

import com.example.contactappsql.data.local.DatabaseHelper
import com.example.contactappsql.data.local.DatabaseQueryImpl
import com.example.contactappsql.data.local.repository.Repository
import com.example.contactappsql.ui.add.AddViewModel
import com.example.contactappsql.ui.add.usecase.AddUseCase
import com.example.contactappsql.ui.home.HomeViewModel
import com.example.contactappsql.ui.home.usecase.HomeUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(), homeUseCase = get()) }
    viewModel { AddViewModel(get(), addUseCase = get()) }
}


val repositoryModule = module {
    single { Repository() }
}

val sqlModule = module {
    single { DatabaseHelper(androidContext()) }
    single {
        DatabaseQueryImpl(
            androidContext(), helper =  get()
        )
    }
}

val useCaseModule = module {
    single { AddUseCase(databaseQueryImpl = get()) }
    single { HomeUseCase(queryImpl = get()) }
}