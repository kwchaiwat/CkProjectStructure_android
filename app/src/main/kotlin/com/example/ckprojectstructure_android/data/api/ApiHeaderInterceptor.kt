package com.example.ckprojectstructure_android.data.api

import okhttp3.Interceptor
import okhttp3.Response

class ApiHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val authorisedRequest = originalRequest.newBuilder()
            .build()

        return chain.proceed(authorisedRequest)
    }
}