package com.example.mvvmcomposeexample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mvvmcomposeexample.screens.DetailScreen
import com.example.mvvmcomposeexample.screens.DetailScreenModel
import com.example.mvvmcomposeexample.screens.MainScreen
import com.example.mvvmcomposeexample.view.LocalEmployeeViewModel
import com.example.mvvmcomposeexample.viewmodel.EmployeeViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val employeeViewModel: EmployeeViewModel = viewModel()

    CompositionLocalProvider(LocalEmployeeViewModel provides employeeViewModel) {
        NavHost(
            modifier = Modifier,
            navController = navController,
            startDestination = Screen.MainScreen.route
        ) {
            composable(Screen.MainScreen.route) {
                MainScreen(navController)
            }
            composable(
                route = Screen.DetailScreen.route,
                arguments = listOf(
                    navArgument(name = "firstName") {
                        type = NavType.StringType
                    },
                    navArgument(name = "lastName") {
                        type = NavType.StringType
                    },
                    navArgument(name = "username") {
                        type = NavType.StringType
                    },
                    navArgument(name = "gender") {
                        type = NavType.StringType
                    },
                )
            ) { backstackEntry ->
                val args = backstackEntry.arguments
                val model = DetailScreenModel(
                    args?.getString("firstName"),
                    args?.getString("lastName"),
                    args?.getString("username"),
                    args?.getString("gender")
                )
                DetailScreen(navController, model)
            }
        }
    }
}