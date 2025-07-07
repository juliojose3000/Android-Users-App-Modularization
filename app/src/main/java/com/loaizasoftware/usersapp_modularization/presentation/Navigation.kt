package com.loaizasoftware.usersapp_modularization.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.loaizasoftware.features.Routes
import com.loaizasoftware.features.users.AddUserScreen
import com.loaizasoftware.features.users.UsersScreen
import com.loaizasoftware.features.users.UsersViewModel

@Composable
fun Navigation(viewModel: UsersViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SHOW_ALL.route) {
        composable(Routes.SHOW_ALL.route) {

            val hasFetched = rememberSaveable { mutableStateOf(false) }

            LaunchedEffect(key1 = Unit) {
                if(!hasFetched.value) {
                    viewModel.getUsers()
                    hasFetched.value = true
                }
            }
            UsersScreen(viewModel = viewModel, navHostController = navController)
        }
        composable(Routes.ADD_USER.route) {
            AddUserScreen(viewModel = viewModel, navHostController = navController)
        }
    }

}


