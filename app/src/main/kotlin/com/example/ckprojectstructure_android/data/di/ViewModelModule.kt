package com.example.ckprojectstructure_android.data.di

import com.example.ckprojectstructure_android.presentation.covidstatus.CovidStatusViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CovidStatusViewModel(get()) }
}
