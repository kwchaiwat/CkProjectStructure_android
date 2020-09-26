package com.example.ckprojectstructure_android.data.repository

import com.example.ckprojectstructure_android.presentation.covidstatus.model.JsonCovidNineteen
import io.reactivex.Observable

interface ApiRepository {
    fun getCovidNineteen(): Observable<JsonCovidNineteen>
}