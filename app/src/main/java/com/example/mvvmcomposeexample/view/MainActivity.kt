package com.example.mvvmcomposeexample.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Surface
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.mvvmcomposeexample.navigation.Navigation
import com.example.mvvmcomposeexample.viewmodel.EmployeeViewModel

val LocalEmployeeViewModel = compositionLocalOf<EmployeeViewModel> {
    error("ProfileViewModel not provided")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier
                    .background(Color.Blue)
                    .fillMaxHeight()
            ) {
                Navigation()
            }
        }
    }
}