package com.example.ckprojectstructure_android

import android.app.Application
import com.example.ckprojectstructure_android.data.di.*
import com.inthecheesefactory.thecheeselibrary.manager.Contextor
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CkApplication : Application() {
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
        super.onCreate()
        // Method from this class
        setUpContext()

        // Method from this class
        setUpKoin()
    }

    override fun onTerminate() {
        super.onTerminate()
        compositeDisposable.clear()
    }

    private fun setUpContext() {
        Contextor.getInstance().init(this)
    }

    private fun setUpKoin() {
        startKoin {
            androidLogger()
            androidContext(this@CkApplication)
            modules(
                listOf(
                    preferenceModule,
                    networkModule,
                    fragmentModule,
                    utilityModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }

}