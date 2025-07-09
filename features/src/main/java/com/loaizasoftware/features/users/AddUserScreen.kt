package com.loaizasoftware.features.users

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.loaizasoftware.core.composables.LoaderIndicator
import com.loaizasoftware.core.ext.showToast
import com.loaizasoftware.core.ui.UiState
import com.loaizasoftware.domain.models.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddUserScreen(viewModel: UsersViewModel, navHostController: NavHostController) {

    val context = LocalContext.current
    val uiState = viewModel.uiStateFlow.collectAsState().value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Add User") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .clickable {
                                navHostController.navigateUp()
                            }
                    )
                }
            )
        },
    ) { padding ->

        when(uiState) {

            is UiState.Error -> {
                context showToast uiState.error
            }
            is UiState.Loading -> {
                LoaderIndicator()
            }
            is UiState.Success -> {
                UserForm(padding, viewModel)
            }

        }


    }

}

@Composable
fun UserForm(padding: PaddingValues, viewModel: UsersViewModel) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(padding)
    ) {

        val (usernameRef, userLastnameRef, userAgeRef, userEmailRef, createUserBtnRef) = createRefs()

        var usernameText by remember { mutableStateOf("") }
        var userLastnameText by remember { mutableStateOf("") }
        var userAgeText by remember { mutableStateOf("") }
        var userEmailText by remember { mutableStateOf("") }

        OutlinedTextField(
            value = usernameText,
            onValueChange = { usernameText = it },
            label = { Text("Name") },
            modifier = Modifier.constrainAs(usernameRef) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        OutlinedTextField(
            value = userLastnameText,
            onValueChange = { userLastnameText = it },
            label = { Text("Lastname") },
            modifier = Modifier.constrainAs(userLastnameRef) {
                top.linkTo(usernameRef.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        OutlinedTextField(
            value = userAgeText,
            onValueChange = { userAgeText = it },
            label = { Text("Age") },
            modifier = Modifier.constrainAs(userAgeRef) {
                top.linkTo(userLastnameRef.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        OutlinedTextField(
            value = userEmailText,
            onValueChange = { userEmailText = it },
            label = { Text("Email") },
            modifier = Modifier.constrainAs(userEmailRef) {
                top.linkTo(userAgeRef.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Button(
            modifier = Modifier
                .constrainAs(createUserBtnRef) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(16.dp),
            onClick = {

                val user = User(
                    name = usernameText,
                    lastname = userLastnameText,
                    age = userAgeText.toInt(),
                    photoUrl = "",
                    email = userEmailText
                )

                viewModel.createUser(user).also {
                    usernameText = ""
                    userLastnameText = ""
                    userAgeText = ""
                    userEmailText = ""
                }

            }
        ) {
            Text("Add User")
        }

    }


}

