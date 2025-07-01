package com.loaizasoftware.features.users

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loaizasoftware.core.ext.showToast
import com.loaizasoftware.core.ui.UiState
import com.loaizasoftware.domain.models.User

@Composable
fun UsersScreen(viewModel: UsersViewModel, paddingValues: PaddingValues) {

    val uiState = viewModel.uiStateFlow.collectAsState().value
    val context = LocalContext.current

    when (uiState) {

        is UiState.Loading -> {
            //Show Loader
            CircularProgressIndicator(color = Color.Blue)
        }

        is UiState.Success -> {
            val users = uiState.data as List<User>
            UsersList(users, paddingValues)
        }

        is UiState.Error -> {
            val error = uiState.error
            context showToast error
        }
    }

}

@Composable
fun UsersList(users: List<User>, paddingValues: PaddingValues) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.White)
    ) {

        items(users.size) { i ->

            val user = users[i]

            Text(
                text = user.name + user.lastname,
                style = MaterialTheme.typography.bodyLarge
            )

        }

    }

}

@Preview
@Composable
fun UsersListPreview() {

    val users = listOf(User(1, "Julio", 25, "Segura", "", ""))

    UsersList(users, PaddingValues(16.dp))

}