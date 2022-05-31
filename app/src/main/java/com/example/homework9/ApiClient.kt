package com.example.homework9

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private lateinit var retorofit: Retrofit
    private lateinit var okHttpClient: OkHttpClient

    fun initClients() {
        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
        retorofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun <S> getService(serviceClass: Class<S>): S {
        return retorofit.create(serviceClass)
    }

    val getReqResApi: ReqResApi
        get() = getService(ReqResApi::class.java)
}