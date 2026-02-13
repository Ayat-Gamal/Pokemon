package com.example.pokemon.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {
    @Serializable
    data object Pokedex : Screen

    @Serializable
    data object Search : Screen

    @Serializable
    data object Favorite : Screen

    @Serializable
    data class PokemonDetail(val id: Int, val name: String) : Screen
}