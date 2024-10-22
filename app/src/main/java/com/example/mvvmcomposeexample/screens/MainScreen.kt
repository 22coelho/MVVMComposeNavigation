package com.example.mvvmcomposeexample.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mvvmcomposeexample.model.User
import com.example.mvvmcomposeexample.view.LocalEmployeeViewModel

@Composable
fun MainScreen(navController: NavController) {
    EmployeeComposable(navController)
}

@Composable
fun EmployeeComposable(navController: NavController) {
    val viewModel = LocalEmployeeViewModel.current
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
            LazyColumn {
                itemsIndexed(emps) { index, item ->
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp), onClick = {
                        navController.navigate("detail_screen/${item.firstName}/${item.lastName}/${item.username}/${item.gender}")
                    }) {
                        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                            Text(item.firstName)
                            Text(item.lastName)
                            Text(item.username)
                            Text(item.gender)
                        }
                    }
                    if (index < emps.lastIndex) {
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}