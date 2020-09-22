package com.example.ckprojectstructure_android.data.di

import com.projectstructure.ck.utilitylibrary.view.CkLoadingDialogView
import org.koin.dsl.module

val utilityModule = module {
    factory { (isCancelable: Boolean) -> provideCkLoadingDialogView(isCancelable) }
}

private fun provideCkLoadingDialogView(isCancelable: Boolean): CkLoadingDialogView {
    return CkLoadingDialogView.newInstance(isCancelable)
}
