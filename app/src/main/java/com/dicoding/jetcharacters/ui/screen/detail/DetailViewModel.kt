package com.dicoding.jetcharacters.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.jetcharacters.data.CharacterRepository
import com.dicoding.jetcharacters.model.Character
import com.dicoding.jetcharacters.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel (
    private val repository: CharacterRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<Character>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Character>>
        get() = _uiState

    fun getCharacterById(id: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getCharacterById(id))
        }
    }

}
