package com.example.mvvmcomposeexample.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mvvmcomposeexample.model.User
import com.example.mvvmcomposeexample.viewmodel.EmployeeViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: EmployeeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier
                    .background(Color.Blue)
                    .fillMaxHeight()
            ) {
                EmployeeComposable(viewModel)
            }
        }
    }
}

@Composable
fun EmployeeComposable(viewModel: EmployeeViewModel) {
    val employees by viewModel.employees.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchEmployees()
    }

    Column(
        modifier = Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(4.dp))
            .padding(16.dp)
    ) {
        if (employees?.users.isNullOrEmpty()) {
            Text("Loading...")
        } else {
            var emps = employees?.users as List<User>
            emps.let {
                LazyColumn {
                    items(it) {
                        Text(it.firstName)
                        Text(it.lastName)
                        Text(it.username)
                        Text(it.gender)
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}
