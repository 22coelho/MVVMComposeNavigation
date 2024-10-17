package com.example.mvvmcomposeexample.model

data class Employees(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)