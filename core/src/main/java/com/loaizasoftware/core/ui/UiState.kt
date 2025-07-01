package com.loaizasoftware.core.ui

sealed class UiState {
    data object Loading: UiState()
    data class Success(val data: Any): UiState()
    data class Error(val error: String): UiState()
}