package com.example.pokemon.domain.model

/**
 * Domain model for Pokemon detail screen
 * Contains all information needed for the detail view
 */
data class PokemonDetail(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val types: List<PokemonType>,
    val height: Int, // in decimeters (10 = 1 meter)
    val weight: Int, // in hectograms (10 = 1 kg)
    val stats: PokemonStats,
    val abilities: List<Ability>,
    val description: String,
    val isFavorite: Boolean = false
) {
    val formattedNumber: String
        get() = "#${id.toString().padStart(3, '0')}"

    val displayName: String
        get() = name.replaceFirstChar { it.uppercase() }

    // Convert height to meters
    val heightInMeters: String
        get() = "${height / 10.0}m"

    // Convert weight to kg
    val weightInKg: String
        get() = "${weight / 10.0}kg"
}

/**
 * Pokemon stats for the detail screen
 */
data class PokemonStats(
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val specialAttack: Int,
    val specialDefense: Int,
    val speed: Int
) {
    // Total stats (useful for comparing Pokemon)
    val total: Int
        get() = hp + attack + defense + specialAttack + specialDefense + speed
}

/**
 * Pokemon ability
 */
data class Ability(
    val name: String,
    val isHidden: Boolean = false
) {
    val displayName: String
        get() = name.split("-")
            .joinToString(" ") { it.replaceFirstChar { char -> char.uppercase() } }
}