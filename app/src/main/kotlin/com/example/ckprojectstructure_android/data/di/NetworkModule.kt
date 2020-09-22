package com.example.ckprojectstructure_android.data.di

import com.example.ckprojectstructure_android.data.api.ApiDateDeserializer
import com.example.ckprojectstructure_android.data.api.ApiHeaderInterceptor
import com.example.ckprojectstructure_android.data.api.ApiService
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.orhanobut.logger.BuildConfig
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideProductFlavor() }
    single { provideGson(get()) }
    single { provideApiDateDeserializer() }
    single { provideApiHeaderInterceptor() }
    single { provideRetrofitBuilder(get()) }
    single { provideOkHttpClientBuilder(get()) }
    single { provideApiService(get(), get()) }
}

private fun provideProductFlavor(): String {
    return BuildConfig.FLAVOR
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


private fun provideApiHeaderInterceptor(): ApiHeaderInterceptor {
    return ApiHeaderInterceptor()
}

private fun provideOkHttpClientBuilder(
    apiHeaderInterceptor: ApiHeaderInterceptor
): OkHttpClient.Builder {
    val httpClientBuilder = OkHttpClient.Builder()

    httpClientBuilder.addInterceptor(apiHeaderInterceptor)

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
        .baseUrl("")
        .build()
        .create(ApiService::class.java)
}