package com.loaizasoftware.usersapp_modularization.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.loaizasoftware.features.users.UsersScreen
import com.loaizasoftware.features.users.UsersViewModel
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

