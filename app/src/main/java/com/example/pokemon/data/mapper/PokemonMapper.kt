package com.example.pokemon.data.mapper

import com.example.pokemon.data.remote.dto.*
import com.example.pokemon.domain.model.*

/**
 * Extension function to convert PokemonDetailDto to Pokemon (for list view)
 */
fun PokemonDetailDto.toPokemon(): Pokemon {
    return Pokemon(
        id = id,
        name = name,
        imageUrl = sprites.other?.officialArtwork?.frontDefault
            ?: sprites.frontDefault
            ?: "",
        types = types.map { typeSlot ->
            PokemonType.fromString(typeSlot.type.name)
        },
        isFavorite = false
    )
}

/**
 * Extension function to convert PokemonDetailDto + PokemonSpeciesDto to PokemonDetail
 */
fun PokemonDetailDto.toPokemonDetail(speciesDto: PokemonSpeciesDto?): PokemonDetail {
    return PokemonDetail(
        id = id,
        name = name,
        imageUrl = sprites.other?.officialArtwork?.frontDefault
            ?: sprites.frontDefault
            ?: "",
        types = types.map { typeSlot ->
            PokemonType.fromString(typeSlot.type.name)
        },
        height = height,
        weight = weight,
        stats = stats.toStats(),
        abilities = abilities.map { abilitySlot ->
            Ability(
                name = abilitySlot.ability.name,
                isHidden = abilitySlot.isHidden
            )
        },
        description = speciesDto?.getEnglishDescription() ?: "No description available.",
        isFavorite = false
    )
}

/**
 * Convert list of StatDto to PokemonStats
 */
private fun List<StatDto>.toStats(): PokemonStats {
    val statsMap = associate { it.stat.name to it.baseStat }
    return PokemonStats(
        hp = statsMap["hp"] ?: 0,
        attack = statsMap["attack"] ?: 0,
        defense = statsMap["defense"] ?: 0,
        specialAttack = statsMap["special-attack"] ?: 0,
        specialDefense = statsMap["special-defense"] ?: 0,
        speed = statsMap["speed"] ?: 0
    )
}

/**
 * Get the first English description from flavor text entries
 */
private fun PokemonSpeciesDto.getEnglishDescription(): String {
    return flavorTextEntries
        .firstOrNull { it.language.name == "en" }
        ?.flavorText
        ?.replace("\n", " ")
        ?.replace("\u000c", " ") // Remove form feed characters
        ?: "No description available."
}

/**
 * Helper to get Pokemon ID from list item URL
 */
fun PokemonListItemDto.extractId(): Int {
    return url.trimEnd('/').split("/").last().toIntOrNull() ?: 0
}