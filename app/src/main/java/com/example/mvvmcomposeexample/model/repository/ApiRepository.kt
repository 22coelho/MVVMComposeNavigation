package com.example.mvvmcomposeexample.model.repository

import com.example.mvvmcomposeexample.model.Employees
import com.example.mvvmcomposeexample.model.api.RetrofitInstance

class ApiRepository {
    private val service = RetrofitInstance.getEmployeeService

     suspend fun getEmployee(): Employees {
        return service.getEmployees()
    }
}