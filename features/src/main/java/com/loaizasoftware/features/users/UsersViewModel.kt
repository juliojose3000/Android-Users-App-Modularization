package com.loaizasoftware.features.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loaizasoftware.core.ui.UiState
import com.loaizasoftware.domain.usecases.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(val getUsersUseCase: GetUsersUseCase): ViewModel() {

    private val _uiStateFlow: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiStateFlow: StateFlow<UiState> = _uiStateFlow.asStateFlow()

    fun getUsers() {

        _uiStateFlow.value = UiState.Loading

        viewModelScope.launch {

            try {
                getUsersUseCase(Unit).also { _uiStateFlow.value = UiState.Success(it) }
            } catch (e: Exception) {
                _uiStateFlow.value = UiState.Error(e.message.toString())
            }

        }

    }

}