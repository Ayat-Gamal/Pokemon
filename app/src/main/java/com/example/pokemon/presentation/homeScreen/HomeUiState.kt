package com.example.pokemon.presentation.homeScreen

import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.util.DummyData

data class HomeUiState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val pokemonList: List<Pokemon> = emptyList(),
    val error: String? = null,
    val isEmpty: Boolean = false,
    val searchQuery : String? = null
)