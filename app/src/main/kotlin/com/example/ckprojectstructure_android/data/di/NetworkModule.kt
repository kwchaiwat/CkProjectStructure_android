package com.example.ckprojectstructure_android.data.di

import com.example.ckprojectstructure_android.data.api.ApiDateDeserializer
import com.example.ckprojectstructure_android.data.api.ApiService
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideGson(get()) }
    single { provideApiDateDeserializer() }
    single { provideRetrofitBuilder(get()) }
    single { provideOkHttpClientBuilder() }
    single { provideApiService(get(), get()) }
}

private fun provideGson(apiDateDeserializer: ApiDateDeserializer): Gson {
    return GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .registerTypeAdapter(Date::class.java, apiDateDeserializer)
        .create()
}

private fun provideApiDateDeserializer(): ApiDateDeserializer {
    return ApiDateDeserializer()
}

private fun provideOkHttpClientBuilder(): OkHttpClient.Builder {
    val httpClientBuilder = OkHttpClient.Builder()

    httpClientBuilder.connectTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(3, TimeUnit.MINUTES)
        .readTimeout(3, TimeUnit.MINUTES)

    return httpClientBuilder
}

private fun provideRetrofitBuilder(gson: Gson): Retrofit.Builder {
    return Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
}

private fun provideApiService(
    retrofitBuilder: Retrofit.Builder,
    httpClientBuilder: OkHttpClient.Builder
): ApiService {
    val okHttpClient = httpClientBuilder
        .build()

    return retrofitBuilder
        .client(okHttpClient)
        .baseUrl("https://api.chaiwat.com")
        .build()
        .create(ApiService::class.java)
}