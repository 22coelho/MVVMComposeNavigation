package com.example.mvvmcomposeexample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcomposeexample.model.Employees
import com.example.mvvmcomposeexample.model.repository.ApiRepository
import kotlinx.coroutines.launch

class EmployeeViewModel: ViewModel() {
    private val repository = ApiRepository()
    private val _employees = MutableLiveData<Employees>()

    val employees: LiveData<Employees> = _employees

    fun fetchEmployees() {
        viewModelScope.launch {
            try {
                val empl = repository.getEmployee()
                _employees.value = empl
            } catch (e: Exception) {
                Log.d("Repository", "Fetching employees exception ${e.message}")
            }
        }
    }
}