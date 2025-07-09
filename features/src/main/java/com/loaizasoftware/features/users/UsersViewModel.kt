package com.loaizasoftware.features.users

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loaizasoftware.core.ui.UiState
import com.loaizasoftware.domain.models.User
import com.loaizasoftware.domain.usecases.CreateUserUseCase
import com.loaizasoftware.domain.usecases.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    val getUsersUseCase: GetUsersUseCase,
    val createUserUseCase: CreateUserUseCase
) : ViewModel() {

    private val _uiStateFlow: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiStateFlow: StateFlow<UiState> = _uiStateFlow.asStateFlow()

    fun getUsers() {

        _uiStateFlow.value = UiState.Loading

        viewModelScope.launch {

            getUsersUseCase(Unit).fold(
                onSuccess = {
                    _uiStateFlow.value = UiState.Success(it)
                },
                onFailure = {
                    Log.e("MyTAG", it.message ?: "Unknown error")
                    _uiStateFlow.value = UiState.Error(it.message ?: "Unknown error")
                }
            )

        }

    }

    fun createUser(user: User) {

        _uiStateFlow.value = UiState.Loading

        viewModelScope.launch {

            createUserUseCase(user).fold(
                onSuccess = {
                    _uiStateFlow.value = UiState.Success(Unit)
                },
                onFailure = {
                    Log.e("MyTAG", it.message ?: "Unknown error")
                    _uiStateFlow.value = UiState.Error(it.message ?: "Unknown error")
                }
            )

        }

    }

}