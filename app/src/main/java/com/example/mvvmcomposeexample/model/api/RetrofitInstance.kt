package com.example.mvvmcomposeexample.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://dummyjson.com/"
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getEmployeeService: GetEmployeeService by lazy {
        retrofit.create(GetEmployeeService::class.java)
    }
}