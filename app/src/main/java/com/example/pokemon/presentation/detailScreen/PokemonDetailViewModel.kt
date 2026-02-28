package com.example.pokemon.presentation.detailScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: PokemonRepository,
) : ViewModel() {
    private val _selectedPokemon = MutableStateFlow<Pokemon?>(null)
    val selectedPokemon: StateFlow<Pokemon?> = _selectedPokemon


    fun selectedPokemon(pokemon: Int) {
        val poke = repository.getPokemon(pokemonId = pokemon)
        _selectedPokemon.value = poke
    }
}

