package com.example.homework9

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqResApi {

    @GET("users")
    fun getUsers(@Query("page") page: Int = 1): Call<ReqresResponse<List<User>>>
}