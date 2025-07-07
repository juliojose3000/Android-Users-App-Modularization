package com.loaizasoftware.features.users

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.loaizasoftware.core.composables.AsyncImageWithLoader
import com.loaizasoftware.core.composables.LoaderIndicator
import com.loaizasoftware.core.ext.showToast
import com.loaizasoftware.core.ui.UiState
import com.loaizasoftware.domain.models.User
import com.loaizasoftware.features.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersScreen(viewModel: UsersViewModel, navHostController: NavHostController) {

    val uiState = viewModel.uiStateFlow.collectAsState().value
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Users") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate(Routes.ADD_USER.route)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add User")
            }
        }
    ) { padding ->

        when (uiState) {

            is UiState.Loading -> {
                LoaderIndicator()
            }

            is UiState.Success -> {
                val users = uiState.data as List<User>
                UsersList(users, padding)
            }

            is UiState.Error -> {
                val error = uiState.error
                context showToast error
            }
        }

    }

}

@Composable
fun UsersList(users: List<User>, paddingValues: PaddingValues) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.White),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(users.size) { i ->
            UserItemRow(users[i])
        }

    }

}

@Composable
fun UserItemRow(user: User) {

    Row(modifier = Modifier
        .height(100.dp)
        .fillMaxWidth()
        .border(
            width = 1.dp,
            color = Color.Gray,
            shape = RoundedCornerShape(12.dp)
        )
        .clip(RoundedCornerShape(12.dp))
        .padding(16.dp)
    ) {

        AsyncImageWithLoader(user.photoUrl)

        Spacer(modifier = Modifier.width(16.dp))

        Column {

            Text(
                text = "${user.name} ${user.lastname}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "${user.age} years old",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = user.email,
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Italic
                )
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