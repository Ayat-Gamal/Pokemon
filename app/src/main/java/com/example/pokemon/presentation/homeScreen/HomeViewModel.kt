package com.example.pokemon.presentation.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState(isLoading = true))
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        loadPokemon()
    }

    fun loadPokemon() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            try {
                delay(2000)
                val result = repository.getAllPokemon()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        pokemonList = result,
                    )
                }

            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "Unkonwn Error"
                    )
                }
            }
        }
    }
}
