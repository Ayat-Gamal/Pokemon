package com.example.pokemon.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * DTO for Pokemon species response
 * Endpoint: /pokemon-species/{id}
 * Used to get Pokemon descriptions/flavor text
 */
@Serializable
data class PokemonSpeciesDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntryDto>,
    @SerialName("generation")
    val generation: GenerationDto
)

/**
 * DTO for flavor text entry (description in different languages)
 */
@Serializable
data class FlavorTextEntryDto(
    @SerialName("flavor_text")
    val flavorText: String,
    @SerialName("language")
    val language: LanguageDto,
    @SerialName("version")
    val version: VersionDto
)

/**
 * DTO for language info
 */
@Serializable
data class LanguageDto(
    @SerialName("name")
    val name: String
)

/**
 * DTO for version info
 */
@Serializable
data class VersionDto(
    @SerialName("name")
    val name: String
)

/**
 * DTO for generation info
 */
@Serializable
data class GenerationDto(
    @SerialName("name")
    val name: String
)