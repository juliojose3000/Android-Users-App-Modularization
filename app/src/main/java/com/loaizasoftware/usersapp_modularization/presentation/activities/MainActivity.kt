package com.loaizasoftware.usersapp_modularization.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.loaizasoftware.features.users.UsersViewModel
import com.loaizasoftware.usersapp_modularization.presentation.navigation.Navigation
import com.loaizasoftware.usersapp_modularization.presentation.ui.theme.UsersAppModularizationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val usersViewModel by viewModels<UsersViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UsersAppModularizationTheme {
                Navigation(viewModel = usersViewModel)
            }
        }
    }
}

