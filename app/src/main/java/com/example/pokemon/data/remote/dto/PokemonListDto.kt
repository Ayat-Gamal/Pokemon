package com.example.pokemon.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * DTO for paginated Pokemon list response
 * Endpoint: /pokemon?limit=20&offset=0
 */
@Serializable
data class PokemonListResponseDto(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String? = null,
    @SerialName("previous")
    val previous: String? = null,
    @SerialName("results")
    val results: List<PokemonListItemDto>
)

/**
 * DTO for individual Pokemon in the list
 * Note: This only contains name and URL, need to call detail endpoint for full info
 */
@Serializable
data class PokemonListItemDto(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
) {
    // Helper to extract Pokemon ID from URL
    // URL format: https://pokeapi.co/api/v2/pokemon/1/
    val id: Int
        get() = url.trimEnd('/').split("/").last().toInt()
}