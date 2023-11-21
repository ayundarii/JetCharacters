package com.dicoding.jetcharacters.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dicoding.jetcharacters.data.CharacterRepository
import com.dicoding.jetcharacters.model.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(
    private val repository: CharacterRepository
    ) : ViewModel() {

    private val _groupedCharacters = MutableStateFlow(
        repository.getCharacters()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )

    val groupedCharacters: StateFlow<Map<Char, List<Character>>> get() = _groupedCharacters

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedCharacters.value = repository.searchCharacters(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }

}