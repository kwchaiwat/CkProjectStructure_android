package com.example.ckprojectstructure_android.data.repository

import com.example.ckprojectstructure_android.data.api.ApiService
import com.example.ckprojectstructure_android.presentation.covidstatus.model.JsonCovidNineteen
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ApiRepositoryImpl(
    private val apiService: ApiService
) : ApiRepository {

    override fun getCovidNineteen(): Observable<JsonCovidNineteen> {
        return apiService.getCovieNineteen()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}