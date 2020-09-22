package com.example.ckprojectstructure_android.data.api

import com.example.ckprojectstructure_android.presentation.main.model.JsonCovidNineteen
import retrofit2.http.GET
import io.reactivex.Observable

interface ApiService {

    @GET("https://covid19.th-stat.com/api/open/today/")
    fun getCovieNineteen(): Observable<JsonCovidNineteen>

}