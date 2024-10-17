package com.example.mvvmcomposeexample.model.api

import com.example.mvvmcomposeexample.model.Employees
import retrofit2.http.GET

interface GetEmployeeService {
    @GET("users")
    suspend fun getEmployees(): Employees
}