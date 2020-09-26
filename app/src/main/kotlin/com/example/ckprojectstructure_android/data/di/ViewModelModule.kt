package com.example.ckprojectstructure_android.data.di

import com.example.ckprojectstructure_android.presentation.covidstatus.CovidStatusViewModel
import com.example.ckprojectstructure_android.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { CovidStatusViewModel(get()) }
}
