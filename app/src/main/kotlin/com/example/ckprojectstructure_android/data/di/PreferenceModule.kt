package com.example.ckprojectstructure_android.data.di

import android.content.Context
import com.example.ckprojectstructure_android.data.preference.UserPreference
import org.koin.dsl.module

val preferenceModule = module {
    single { provideUserPreference(get()) }
}


fun provideUserPreference(context: Context): UserPreference {
    return UserPreference(context)
}