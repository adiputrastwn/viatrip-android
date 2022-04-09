package com.adiputrastwn.viatrip.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adiputrastwn.viatrip.data.HighlightRepository
import com.adiputrastwn.viatrip.models.Highlight
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val highlightRepository: HighlightRepository
) : ViewModel() {

    sealed class HomeUiState {
        object Loading : HomeUiState()
        data class HighlightList(val highlights: List<Highlight>) : HomeUiState()
        data class Error(val exception: Throwable) : HomeUiState()
    }

    private var _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            highlightRepository.latestHighlights
                .collect { highlights ->
                    _uiState.value = HomeUiState.HighlightList(highlights)
                }
        }
    }
}

