package com.example.pokemon.domain.model

import kotlinx.serialization.Serializable

/**
 * Domain model for Pokemon (used in list/grid view)
 * This is what the UI layer uses
 */
@Serializable
data class Pokemon(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val types: List<PokemonType>,
    val isFavorite: Boolean = false
) {
    // Helper to format Pokemon number (#001, #025, etc.)
    val formattedNumber: String
        get() = "#${id.toString().padStart(3, '0')}"

    // Helper to capitalize name (bulbasaur -> Bulbasaur)
    val displayName: String
        get() = name.replaceFirstChar { it.uppercase() }
}