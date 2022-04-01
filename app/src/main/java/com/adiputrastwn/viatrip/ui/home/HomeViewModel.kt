package com.adiputrastwn.viatrip.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    sealed class HomeUiState {
        object Loading : HomeUiState()
        data class HighlightList(val highlight: List<HighlightItemUiState>) : HomeUiState()
        data class Error(val exception: Throwable) : HomeUiState()
    }

    private val _uiState = MutableStateFlow(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {

        }
    }

    data class HighlightItemUiState(
        val title: String,
        val url: String
    )
}

